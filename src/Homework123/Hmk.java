package Homework123;
/*
Extra Homework 1:
    剪刀石头布 (1、剪刀 2、石头 3、布)
Extra Homework 2:
    个人所得税：
        -起征点：5000
        -从控制台输入薪水，计算出税后的工资薪水
 */
import java.util.Random;
import java.util.Scanner;

public class Hmk {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();

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
    public void Hmk3_1(){
        String str;
        System.out.println("Please input a string: ");
        str = this.in.nextLine();
        char a;
        System.out.println("Please input a char: ");
        a = this.in.next().charAt(0);
        int i=0,j=0;
        int position[]=new int[100];
        for (char b:str.toCharArray()){
            if (a==b){
                position[j]=i;
                j++;
            }
            i++;
        }
        System.out.print("It shows at:");
        for (i=0;i<j;i++){
            System.out.print(position[i]+" ");
        }
    }
    public void Hmk3_2(){
        int red[] = new int[33];
        int blue[] = new int[16];
        int ball[] = new int[7];
        for (int i=0;i<33;i++){
            red[i]=i+1;
        }
        for (int i=0;i<16;i++){
            blue[i]=i+1;
        }
        System.out.println("您的双色球号码为: ");
        System.out.print("红球: ");
        for (int i=0;i<6;i++){
            ball[i]=red[rand.nextInt(33)];
            System.out.print(ball[i]+" ");
        }

        ball[6]=blue[rand.nextInt(16)];
        System.out.print('\n'+"蓝球: "+ball[6]);
    }
    public void Hmk3_3(){
        System.out.println("请输入身份证号:");
        String id = in.nextLine();
        int sum = 0;
        char[] chekBit = {'1','0','X','9','8','7','6','5','4','3','2'};
        int[] power = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        char[] strinigAll = id.toCharArray();
        for (int i = 0; i < 17; i++) {
            sum += power[i]*(strinigAll[i] - '0');
        }
        if(strinigAll[17] == chekBit[sum%11]){
            System.out.println("身份证合法");
        }else {
            System.out.println("身份证不合法");
        }
    }
    public void Hmk3_4(){
        System.out.println("请输入十个数字: ");
        int nums[]=new int[10];
        for (int i=0;i<10;i++){
            nums[i]=in.nextInt();
        }
        for (int i=0;i<10;i++){
            for (int j=i+1;j<10;j++){
                if (nums[i]>nums[j]) {
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        System.out.println("升序排序好后的十个数：");
        for (int i=0;i<10;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.print("\n最大数为: "+nums[9]+"\n最小数为: "+nums[0]);
    }
}
