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
import model.Blog;

/**
 *
 * @author Administrator
 */
public class BlogDAO {
    DBConnect mysqlConnect = new DBConnect();

    public int countPage() {
        try {
            String sql = "SELECT COUNT(*) AS TOTAL FROM `blog`";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int countPage;
                countPage = rs.getInt("TOTAL") / 2;
                if (rs.getInt("TOTAL") % 2 != 0) {
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

    public ArrayList<Blog> getBlogByPageNumber(int pageNumber) {
        ArrayList<Blog> lc = new ArrayList<>();
        try {
            String sql = "SELECT blog_id , create_date, content, description, img "
                    + "FROM(SELECT blog_id , create_date, content, description, img, "
                    + "ROW_NUMBER() OVER (ORDER BY create_date DESC) AS Seq FROM  `blog`) as x "
                    + "WHERE Seq BETWEEN ? AND ? ";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, ((pageNumber - 1) * 2) + 1);
            statement.setInt(2, (pageNumber * 2));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"),
                        rs.getDate("create_date"),
                        rs.getString("content"),
                        rs.getString("description"),
                        rs.getString("img"), pageNumber);
                lc.add(b);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }
    
    
    
    public ArrayList<Blog> getBlogForHomePage() {
        ArrayList<Blog> lc = new ArrayList<>();
        try {
            String sql = "SELECT blog_id , create_date, content, description, img FROM blog ORDER BY create_date DESC";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt("blog_id"),
                        rs.getDate("create_date"),
                        rs.getString("content"),
                        rs.getString("description"),
                        rs.getString("img")
                );
                lc.add(b);
            }
        } catch (SQLException ex) {

        } finally {
            mysqlConnect.disconnect();
        }
        return lc;
    }
}