package maphomework;

import oop_poly_hmk.dinner.Person;

import java.util.*;

public class Homework5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        List<Champion> worldCup = new ArrayList<>();
        worldCup.add(new Champion(1,1930,"乌拉圭"));
        worldCup.add(new Champion(2,1934,"意大利"));
        worldCup.add(new Champion(3,1938,"意大利"));
        worldCup.add(new Champion(4,1950,"乌拉圭"));
        worldCup.add(new Champion(5,1954,"德国"));
        worldCup.add(new Champion(6,1958,"巴西"));
        worldCup.add(new Champion(7,1962,"巴西"));
        worldCup.add(new Champion(8,1970,"英格兰"));
        worldCup.add(new Champion(9,1974,"巴西"));
        System.out.println("Please input a year:");
        int years = in.nextInt();
        System.out.println("Please input a ball temp:");
        String team = in2.nextLine();
        Map<Integer, String> map = new HashMap<>();
        for (Champion temp:worldCup){
            map.put(temp.getYear(),temp.getChampion());
            if (temp.getChampion().equals(team)){
                System.out.print(temp.getYear()+" ");
            }
        }
        System.out.println();
        if(map.containsKey(years)) {
            System.out.println(map.get(years));
        }else{
            System.out.println("Year invalid");
        }

    }
}
