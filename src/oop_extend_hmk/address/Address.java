package oop_extend_hmk.address;

public class Address {
    private String province;
    private String city;
    private String street;
    private String postcode;

    public Address(String province, String city, String street, String postcode) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    public Address(){
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
