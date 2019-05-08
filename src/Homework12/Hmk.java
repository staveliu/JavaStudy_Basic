package Homework12;

import java.util.Scanner;

public class Hmk {
    private Scanner in = new Scanner(System.in);
    public void Hmk1_1(){
        System.out.println("Please input a year: ");
        int year = in.nextInt();
        if ((year%400==0 || year%4==0) && (year%100!=0)){
            System.out.println("这是一个闰年");
        }else{
            System.out.println("这是一个平年");
        }
    }
    public void Hmk1_2(){

        System.out.println("Please input a score: ");
        int score = in.nextInt();
        if (score>=90 && score<=100) {
            System.out.println("一个优秀的分数,你好棒啊.");
        }else if (score>=80 && score<90){
            System.out.println("一个评为良好的分数,加油啊.");
        }else if (score>=70 && score<80){
            System.out.println("一个评为良的分数，再加把劲。");
        }else if (score>=60 && score<70){
            System.out.println("一个刚刚及格的分数，还需努力。");
        }else{
            System.out.println("这真是一个杯具。");
        }
    }
    public void Hmk2_1(){
        int i,j;
        for (i=1;i<=9;i++){
            for (j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+'\t');
            }
            System.out.println();
        }
    }
    public void Hmk2_2a(){
        int i,j;
        System.out.println("Please input a number: ");
        int n=in.nextInt();
        for (i=1;i<=n;i++){
            for (j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void Hmk2_2b(){
        int i,j;
        System.out.println("Please input a number: ");
        int n=in.nextInt();
        for (i=1;i<=n;i++){
            for (j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void Hmk2_3(){
        long result=1;
        int n,i;
        System.out.println("Please input a number: ");
        n = in.nextInt();
        System.out.print(n+"! = ");
        for (i=n;i>=1;i--){
            if (i!=1) {
                System.out.print(i + "*");
            }else {
                System.out.print(i);
            }
            result*=i;
        }
        System.out.print(" = "+result);
        System.out.println();
    }
    public void Hmk2_4(){
        double a,n,result;
        System.out.println("请输入底数: ");
        a = in.nextDouble();
        System.out.println("请输入幂数: ");
        n = in.nextDouble();
        result = Math.pow(a,n);
        System.out.println((int)a + "的" + (int)n + "次方是  "+(int)result);
    }
    public void Hmk2_5(){
        int i=0;
        float n=0;
        while (n<=100){
            i++;
            if (n%5!=0){
                n+=2.5;
            }else{
                n-=6;
            }
        }
        System.out.println("小明需要" + i + "天才能买电动玩具");
    }
    public void Hmk2_6(){
        int i=0,n=0;
        while(i<=100){
            i++;
            if (i%2==0){
                System.out.print(i+"  ");
                n++;
            }
            if (n%5==0)
                System.out.println();
        }
    }
}
