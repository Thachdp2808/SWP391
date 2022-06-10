/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Product;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class ProductDAO {
    DBConnect mysqlConnect = new DBConnect();

    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listAll(String sort) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` ORDER BY `products`.`unit_price` " + sort;
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }

    public List<Product> listTop(int quantity) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` LIMIT ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, quantity);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }
    
    
    public List<Product> listTopNew(int quantity) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM `products` ORDER BY product_id DESC LIMIT ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, quantity);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return products;
    }
    
    public Product getProductByID(int id) {
        String sql = "SELECT * FROM `products` WHERE product_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getFloat("unit_price"),
                        rs.getFloat("sale_price"), rs.getInt("unitsln_stock"), rs.getString("brief_information"),
                        rs.getString("description"), rs.getString("url"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `products`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 6;
                if (rs.getInt("TOTAL") % 6 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }

    public ArrayList<Product> getCourseByPageNumber(int pageNumber, String sort) {
        ArrayList<Product> lc = new ArrayList<>();
        try {
            String sql = "SELECT product_id , product_name, unit_price, url "
                    + "FROM(SELECT product_id , product_name, unit_price, url, ROW_NUMBER() OVER (ORDER BY unit_price " + sort + " ) AS Seq FROM  `products`) as x \n"
                    + "WHERE Seq BETWEEN ? AND ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 6) + 1);
            statement.setInt(2, (pageNumber * 6));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                lc.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public ArrayList<Product> getCourseByPageNumber(int pageNumber) {
        ArrayList<Product> lc = new ArrayList<>();
        try {
            String sql = "SELECT product_id , product_name, unit_price, url "
                    + "FROM(SELECT product_id , product_name, unit_price, url, "
                    + "ROW_NUMBER() OVER (ORDER BY product_id) AS Seq FROM  `products`) as x "
                    + "WHERE Seq BETWEEN ? AND ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 6) + 1);
            statement.setInt(2, (pageNumber * 6));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                lc.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM `products` WHERE `products`.`product_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void addProduct(Product p) {
        try {
            String sql = "INSERT INTO `products` (`product_name`, `category_id`, `unit_price`, `unitsln_stock`, `description`, `url`, `description-short`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getName()); //name
            statement.setInt(2, p.getCategoryid()); //category id
            statement.setFloat(3, p.getPrice()); //unit price
            statement.setInt(4, p.getStock()); //stock
            statement.setString(5, p.getDescription()); //description
            statement.setString(6, p.getImg()); // image
            statement.setString(7, p.getSortdesc());
            statement.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public Product findById(String id) {
        try {
            String sql = "SELECT * FROM `products` WHERE `products`.`product_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setCategoryid(rs.getInt("category_id"));
                p.setSalePrice(rs.getFloat("sale_price"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setStock(rs.getInt("unitsln_stock"));
                p.setDescription(rs.getString("description"));
                p.setImg(rs.getString("url"));
                p.setSortdesc(rs.getString("description-short"));
                return p;
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public void update(Product p) {
        try {
            String sql = "UPDATE `products` SET "
                    + "`product_name` = ?, "
                    + "`category_id` = ? , "
                    + "`unit_price` = ?, "
                    + "`unitsln_stock` = ?, "
                    + "`description` = ?, "
                    + "`url` = ?, "
                    + "`description-short` = ? "
                    + "WHERE `products`.`product_id` = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setInt(2, p.getCategoryid());
            statement.setFloat(3, p.getPrice());
            statement.setInt(4, p.getStock());
            statement.setString(5, p.getDescription());
            statement.setString(6, p.getImg());
            statement.setString(7, p.getSortdesc());
            statement.setInt(8, p.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
    }

    public ArrayList<Product> findByName(String query) {
        ArrayList<Product> lc = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `products` WHERE product_name LIKE ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, "%" + query + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getFloat("unit_price"));
                p.setImg(rs.getString("url"));
                lc.add(p);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }

    public static void main(String[] args) {
        
        ProductDAO product = new ProductDAO();
        Product Product = product.findById("1");
        System.out.println(Product);
    }
}
