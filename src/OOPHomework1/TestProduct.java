package OOPHomework1;

public class TestProduct {
    public static void main(String[] args){
        Product[] p = {new Product("篮球",5,80.0f),new Product("VCD带", 6, 25.0f),new Product("钢笔", 3,12.0f)};
        System.out.println("------------------------\n产品订单\n------------------------");
        for (int i=0;i<3;i++){
            double totalPrice = p[i].computeTotalPrice();
            System.out.println("\t产品："+p[i].getProductName());
            System.out.println("\t数量："+p[i].getQuantity());
            System.out.println("\t价格："+p[i].getPrice());
            System.out.println("\t总价："+totalPrice);
            System.out.println("*************************");
        }

    }
}
