package oop_extend_hmk.address;

public class Homework3 {
    public static void main(String[] args){
        DomesticAddress add1 = new DomesticAddress("Hunan","Changsha","Yueluqu","410013");
        InternationalAddress add2 = new InternationalAddress("Florida","Kansas","Big Street","10001","the United States");
        String address1 = add1.toString();
        String address2 = add2.toString();
        System.out.println(address1);
        System.out.println(address2);

    }
}
