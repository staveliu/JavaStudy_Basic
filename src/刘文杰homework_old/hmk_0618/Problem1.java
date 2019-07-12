package 刘文杰homework_old.hmk_0618;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入类名：");
		String strclas = input.nextLine();
		
		Class cls1=Class.forName(strclas);
		
		Class cls2=null;
		System.out.println(cls1.getName());
		while(cls1!=null) {
			cls2=cls1;
			cls1=cls2.getSuperclass();
			if(cls1!=null) {
				System.out.println(cls1.getName());
			}
		}
		
		
		
		
	}

}
