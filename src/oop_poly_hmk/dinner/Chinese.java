package oop_poly_hmk.dinner;

import java.util.Date;

public class Chinese extends Person{
    private final String breakfast="包子，油条，粥和豆浆";
    private final String lunch="米饭，馒头，蔬菜和肉类";
    private final String dinner="粥，馒头，蔬菜和水果";

    public Chinese(String name) {
        super(name);
    }

    public Chinese() {
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
            System.out.println("没到吃 =饭时间！");
        }
    }
}
