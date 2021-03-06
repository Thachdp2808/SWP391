/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thund
 */
public class Favourite {
    private int userID;
    private String productID;
    private String name;
    private int categoryid;
    private float price;
    private float salePrice;
    private int stock;
    private String brief_information;
    private String description;
    private String img;

    public Favourite() {
    }

    public Favourite(int userID, String productID, String name, int categoryid, float price, float salePrice, int stock, String brief_information, String description, String img) {
        this.userID = userID;
        this.productID = productID;
        this.name = name;
        this.categoryid = categoryid;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
        this.brief_information = brief_information;
        this.description = description;
        this.img = img;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrief_information() {
        return brief_information;
    }

    public void setBrief_information(String brief_information) {
        this.brief_information = brief_information;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
