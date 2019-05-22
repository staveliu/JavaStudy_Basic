package oop_poly_hmk.dinner;

import java.util.Date;

public class Foreigners extends Person{
    private final String breakfast="面包加黄油，牛奶，火腿";
    private final String lunch="汉堡，炸马铃薯，一些蔬菜";
    private final String dinner="萨饼，蔬菜，牛肉，水果，甜点，面包";

    public Foreigners(String name) {
        super(name);
    }

    public Foreigners() {
    }

    @Override
    public void Dinner_Time() {
        Date date = new Date();
        int hours = date.getHours();
        System.out.println(super.getName()+" 您好！");
        if (hours >= 7 && hours <= 8) {
            System.out.println(breakfast);
        }else if(hours >= 11 && hours <= 13) {
            System.out.println(lunch);
        }else if(hours >= 17 && hours<=20) {
            System.out.println(dinner);
        }else {
            System.out.println("没到吃饭时间！");
        }
    }
}
