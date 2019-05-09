package Homework123;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hmk Homework = new Hmk();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1、Homework1-1");
            System.out.println("2、Homework1-2");
            System.out.println("3、Homework2-1");
            System.out.println("4、Homework2-2a");
            System.out.println("5、Homework2-2b");
            System.out.println("6、Homework2-3");
            System.out.println("7、Homework2-4");
            System.out.println("8、Homework2-5");
            System.out.println("9、Homework2-6");
            System.out.println("10、Homework3-1");
            System.out.println("11、Homework3-2");
            System.out.println("12、Homework3-3");
            System.out.println("13、Homework3-4");

            System.out.println("Please input a number: ");
            int hmk = in.nextInt();
            switch (hmk) {
                case 1:
                    Homework.Hmk1_1();
                    break;
                case 2:
                    Homework.Hmk1_2();
                    break;
                case 3:
                    Homework.Hmk2_1();
                    break;
                case 4:
                    Homework.Hmk2_2a();
                    break;
                case 5:
                    Homework.Hmk2_2b();
                    break;
                case 6:
                    Homework.Hmk2_3();
                    break;
                case 7:
                    Homework.Hmk2_4();
                    break;
                case 8:
                    Homework.Hmk2_5();
                    break;
                case 9:
                    Homework.Hmk2_6();
                    break;
                case 10:
                    Homework.Hmk3_1();
                    break;
                case 11:
                    Homework.Hmk3_2();
                    break;
                case 12:
                    Homework.Hmk3_3();
                    break;
                case 13:
                    Homework.Hmk3_4();
                    break;
                default:
                    System.out.println("Number Error");
            }
            System.out.println();

        }
    }
}
