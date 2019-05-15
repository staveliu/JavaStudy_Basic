package OOP2Homework;

public class Product {
    private String productName;
    private int quantity;
    private double price;

    public Product(String productName, int quantity, double price){
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(){

    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double computeTotalPrice(){
        double total = quantity*price;
        return total;
    }
}
