package com.mayun.quiz;

import java.util.Optional;
import java.util.Scanner;

public class PrintCharTriangle {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please in put a number of 1-34:");
        int n = in.nextInt();
        if (!((n>0)&&(n<35))){
            try {
                throw new Exception("Number Error");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.exit(0);
            }
        }
        for (int i=n; i>=1; i--){
            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++){
                if (i<=9){
                    System.out.print(i);
                }else{
                    System.out.printf("%c",97-10+i);
                }
            }
            System.out.println();
        }
    }
}
