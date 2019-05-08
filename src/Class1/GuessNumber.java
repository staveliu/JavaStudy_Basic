package Class1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int GuessNumber;
        int RandNumber = rd.nextInt(100);
        do {
            System.out.println("Please input a number you guess: ");
            GuessNumber = in.nextInt();
            if (GuessNumber>RandNumber){
                System.out.println("Too big!! Try again please.");
            }
            if (GuessNumber<RandNumber){
                System.out.println("Too small!! Try again please.");
            }
        }while(GuessNumber!=RandNumber);
        System.out.println("Congratulations!! You get the correct number!!");
    }
}
