package 刘文杰homework_old.hmk_0618;

public class Problem2 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("**********************List相关信息：**********************");
		
		
		try {
		Class cls1=Class.forName("java.util.List");
		System.out.println("类名"+cls1.getName());
		} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		}
		
		try {
			ClassLoader loader=ClassLoader.getSystemClassLoader();
			Class cls2=loader.loadClass("java.util.List");
			System.out.println("包名"+cls2.getPackage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class cls3=int.class;
		System.out.println("是否是基本数据类型:"+cls3.isPrimitive());
		Class cls1=Class.forName("java.util.List");
		System.out.println("是否是数组:"+cls1.isArray());
		Class clss=Class.forName("java.util.List");
		System.out.println("父类的Class对象:"+clss.getSuperclass());
		System.out.println();
		
		System.out.println("**********************List接口指向ArrayList时的相关信息：**********************");
		 	
			ClassLoader loader1=ClassLoader.getSystemClassLoader();
			
			try {
			Class als1=Class.forName("java.util.ArrayList");
			System.out.println("类名"+cls1.getName());
			} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			}
			
			
			try {
				Class als2=loader1.loadClass("java.util.ArrayList");
				System.out.println("包名"+als2.getPackage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Class als3=int.class;
			System.out.println("是否是基本数据类型:"+als3.isPrimitive());
			Class als4=Class.forName("java.util.ArrayList");
			System.out.println("是否是数组:"+als4.isArray());
			
			Class clss1=Class.forName("java.util.ArrayList");
			System.out.println("父类的Class对象:"+clss1.getSuperclass());
	}

}
