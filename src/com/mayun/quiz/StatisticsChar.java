package com.mayun.quiz;

import java.util.*;

public class StatisticsChar {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please input a string:");
        String str = in.next();
        Map<Character,Integer> stastics = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (stastics.containsKey(str.charAt(i))){
                stastics.put(str.charAt(i),stastics.get(str.charAt(i))+1);
            }else{
                stastics.put(str.charAt(i),1);
            }
        }
        Set<Character> chs = stastics.keySet();
        for (char ch:chs){
            System.out.println("\""+ch+"\""+"出现了"+stastics.get(ch)+"次");
        }

    }
}
