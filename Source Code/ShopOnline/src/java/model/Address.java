package model;

/**
 *
 * @author Administrator
 */
public class Address {
    private int countryID;
    Provinces province;
    District district;
    private int eaID;
    private String addressDetail;
    private String status;

    public Address() {
    }
    
    public Address(Provinces province, String status) {
        this.province = province;
        this.status = status;
    }

    public Address(int countryID, Provinces province, District district, int eaID, String addressDetail, String status) {
        this.countryID = countryID;
        this.province = province;
        this.district = district;
        this.eaID = eaID;
        this.addressDetail = addressDetail;
        this.status = status;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public Provinces getProvince() {
        return province;
    }

    public void setProvince(Provinces province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getEaID() {
        return eaID;
    }

    public void setEaID(int eaID) {
        this.eaID = eaID;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
