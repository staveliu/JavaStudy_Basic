package 刘文杰homework_old.hmk_0621;

public class Homework1 {
    public static void main(String[] args){
        String content = "我我....我要..要....要高高高高...薪薪薪...薪薪就.....业业...业";
        System.out.println("Previous: "+content);
        String replace1 = content.replaceAll("\\.","");
        String replace2 = replace1.replaceAll("(\\W)\\1+", "$1");
        System.out.println("After Replace: "+replace2);
    }
}
