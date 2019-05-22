package oophomework3;

public class Homework4 {
    public static void main(String[] args){
        MyMath math = new MyMath();
        System.out.println(math.add(4,5));
        System.out.println(math.add(4.55,5));
        System.out.println(math.add(4.23,5.89));
        System.out.println(math.add("addd","dddd"));
        System.out.println(math.minus(4,5));
        System.out.println(math.minus(4.88,5));
        System.out.println(math.except(4.55,5));
        System.out.println(math.time(4,5));
    }
}
