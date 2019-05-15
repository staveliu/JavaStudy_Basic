package OOP2Homework;

public class WuMingFen {
    private String theMa;
    private int quantity;
    private boolean likeSoup;

    public WuMingFen(String theMa, int quantity, boolean likeSoup) {
        this.theMa = theMa;
        this.quantity = quantity;
        this.likeSoup = likeSoup;
    }

    public WuMingFen(String theMa, int quantity){
        this(theMa,quantity,true);
    }

    public WuMingFen(){
        this("酸辣",2,true);
    }

    public String getTheMa() {
        return theMa;
    }

    public void setTheMa(String theMa) {
        this.theMa = theMa;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isLikeSoup() {
        return likeSoup;
    }

    public void setLikeSoup(boolean likeSoup) {
        this.likeSoup = likeSoup;
    }


}
