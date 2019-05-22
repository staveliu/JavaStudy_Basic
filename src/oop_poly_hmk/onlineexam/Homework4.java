package oop_poly_hmk.onlineexam;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        final int QUESTION_TOTAL_NUMBER=10;
        Question[] questions=new Question[10];
        int tempNum;
        boolean tempType;
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<10;i++){
            tempNum=rd.nextInt(QUESTION_TOTAL_NUMBER)+1;
            tempType=rd.nextBoolean();
            if (tempType) {
                String[] arr = Mysql.getQuestion(tempNum, 1);
                questions[i] = new MultipleQuestion(i + 1, arr[0], arr[1]);
            }else{
                String[] arr = Mysql.getQuestion(tempNum, 0);
                questions[i] = new SingleQuestion(i + 1, arr[0], arr[1]);
            }
        }
        System.out.println("Question generate successfully!");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Now! Start!");
        int correctCount=0;
        for (int i=0;i<10;i++){
            System.out.println("Question "+(i+1));
            questions[i].showQuestion();
            System.out.println("Please input your answer:");
            String userAns = sc.nextLine();
            if (questions[i].checkAnswer(userAns)){
                correctCount++;
                System.out.println("Congratulations! You are correct.");
                System.out.println("You totally get "+correctCount+" correct answer!");
            }
        }
        System.out.println("Finished! Your score is: "+correctCount*10+"/100");
    }
}
