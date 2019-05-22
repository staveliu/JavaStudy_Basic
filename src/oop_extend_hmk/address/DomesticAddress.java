package oop_extend_hmk.address;

public class DomesticAddress extends Address {
    private final String country = "China";

    public DomesticAddress(String province, String city, String street, String postcode) {
        super(province, city, street, postcode);
    }

    public DomesticAddress() {
    }
    public String toString(){
        String add = super.getPostcode()+", "+this.country+", "+super.getProvince()+", "+super.getCity()+", "+super.getStreet();
        return add;
    }
}
