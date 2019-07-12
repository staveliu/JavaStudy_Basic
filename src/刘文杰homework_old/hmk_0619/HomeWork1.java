package 刘文杰homework_old.hmk_0619;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HomeWork1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class cls=String.class;
		Constructor co=cls.getConstructor(null);
		String st=(String)co.newInstance(null);
		System.out.println(st);
		System.out.println(co);
	    
		byte[] by={1};
		Constructor cls1=cls.getConstructor(byte[].class);
		String str=(String)cls1.newInstance(by);
		System.out.println(cls1);
		System.out.println(str);

	}

}
