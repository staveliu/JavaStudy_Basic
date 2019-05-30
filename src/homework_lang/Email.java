package homework_lang;
import java.util.TreeSet;
import java.util.Set;
public class Email {
    public static boolean checkEmail(String email)
    {
        String regex = "^([a-z0-9A-Z]+[-|\\._]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

        if(email.matches(regex))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean chk163(String validEmail){
        String regex = "^([a-z0-9A-Z]+[-|\\.|_]?)+[a-z0-9A-Z]@163.com$";
        if (validEmail.matches(regex)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        String email = "admin@1633.com";
        boolean verify = checkEmail(email);
        if (verify){
            System.out.println("Email is valid!");
            if (chk163(email)){
                System.out.println("is 163");
            }

        }else{
            System.out.println("Invalid");
        }
    }

}
