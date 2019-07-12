package 刘文杰homework_old.hmk_0618;

public class Problem3 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassLoader loader1 = Problem3.class.getClassLoader();
		ClassLoader loader2=null;
		System.out.println("1-------------------------------");
		System.out.println(loader1);
		
		while(loader1!=null) {
			loader2=loader1;
			loader1=loader2.getParent();
			System.out.println(loader2+"的父类加载器是"+loader1);
		}
		
		System.out.println("2------------------------------");
		
		ClassLoader loader=Object.class.getClassLoader();
		System.out.println("加载obj类的类加载器是："+loader);
		
		System.out.println("3------------------------------");
		
		ClassLoader loader3= Problem3.class.getClassLoader();
		System.out.println(loader3);
		
	}

}
