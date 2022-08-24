/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class ElectronicAddress {
    private int eaID;
    private String website,telephone,fax,email;

    public ElectronicAddress() {
    }
    public ElectronicAddress(int eaID) {
        this.eaID=eaID;
    }

    public ElectronicAddress(int eaID, String website, String telephone, String fax, String email) {
        this.eaID = eaID;
        this.website = website;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
    }

    public int getEaID() {
        return eaID;
    }

    public void setEaID(int eaID) {
        this.eaID = eaID;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
