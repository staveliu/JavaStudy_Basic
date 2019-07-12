package 刘文杰homework_old.hmk_0619;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework2 {

	public static void main(String[] args) throws Exception {
		Student stu=new Student("Stave",20);
		System.out.println(getPropertyValue(stu,"name"));

	}
	public static Object getPropertyValue(Object obj,String propertyName) throws Exception {
		Class cls=obj.getClass();
		Field field=cls.getDeclaredField(propertyName);
		String methodName="get"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
		Method method=cls.getMethod(methodName);
		return method.invoke(obj);
	}

}
