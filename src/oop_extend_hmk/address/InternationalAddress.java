package oop_extend_hmk.address;

public class InternationalAddress extends Address {
    private String country;

    public InternationalAddress(String province, String city, String street, String postcode, String country) {
        super(province, city, street, postcode);
        this.country = country;
    }

    public InternationalAddress() {
    }
    public String toString(){
        String add=super.getStreet()+", "+super.getCity()+", "+super.getProvince()+", "+this.country+", "+super.getPostcode();
        return add;
    }
}
