package OOP2Homework.UsersManagement;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Controller test = new Controller();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Please input a command(register/login):");
            String command = in.nextLine();
            if (command.equals("register")){
                System.out.println("Please input a username:");
                String username = in.nextLine();
                System.out.println("Please input a password:");
                String password = in.nextLine();
                System.out.println("Please input a Email:");
                String email = in.nextLine();
                boolean status = test.register(username,password,email);
                if (status){
                    System.out.println("Register Successful.");
                }else{
                    System.out.println("Register Error.");
                }
            }
            if (command.equals("login")){
                System.out.println("Please input a username:");
                String username = in.nextLine();
                System.out.println("Please input a password:");
                String password = in.nextLine();
                boolean status = test.login(username,password);
                if (status){
                    System.out.println("Login Successful.");
                }else{
                    System.out.println("Login Error.");
                }
            }
        }
    }
}
