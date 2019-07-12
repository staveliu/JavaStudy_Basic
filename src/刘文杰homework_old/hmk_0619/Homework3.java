package 刘文杰homework_old.hmk_0619;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework3 {

	public static void main(String[] args) throws Exception {
		Student stu=new Student();
		setProperty(stu,"name","Stave");
		System.out.println(stu);

	}
	public static void setProperty(Object obj,String propertyName,Object propertyValue) throws Exception{
		Class cls=obj.getClass();
		Field field=cls.getDeclaredField(propertyName);
		String methodName="set"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
		Method method=cls.getMethod(methodName, field.getType());
		method.invoke(obj,propertyValue);
	}
}
