package com.mayun.quiz;

import Class1.Array;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class TimeTest {
    public static void main(String[] args){
        int[] a = {1,2,3,4};
        int[] b = new int[a.length];
        for (int i=0;i<a.length;i++){
            b[i]=a[a.length-i-1];
            System.out.println(b[i]);
        }
        a = Arrays.copyOf(b,a.length);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
