package com.mayun.quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ShitouJiandaoBu {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        Map<Integer,String> ways = new HashMap<>();
        ways.put(1,"石头");
        ways.put(2,"剪刀");
        ways.put(3,"布");
        while(true){
            System.out.print("请出拳：1：石头 2：剪刀 3：布：");
            int user = in.nextInt();
            System.out.println("您出的是："+ways.get(user));
            int machine = rand.nextInt(3)+1;
            System.out.println("计算机出的是："+ways.get(machine));
            if ((user == 1 && machine == 2)||(user == 2 && machine == 3)||(user == 3 && machine == 1)){
                System.out.println("您赢了");
            }else if ((user == 1 && machine == 3)||(user == 2 && machine == 1)||(user == 3 && machine == 2)){
                System.out.println("计算机赢了");
            }else {
                System.out.println("您和计算机打平手");
            }
            System.out.println("是否继续？(y/n)");
            String command = in.next();
            if (command.equals("y")){
                continue;
            }else if (command.equals("n")){
                System.out.println("程序结束！");
                break;
            }else{
                System.out.println("错许，请重新输入(y/n)");
            }
        }
    }
}
