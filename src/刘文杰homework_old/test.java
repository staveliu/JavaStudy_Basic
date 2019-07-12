package 刘文杰homework_old;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) throws Exception{


        List<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(234);
        list.add(333);
        list.add(42);
        Class<? extends Collection> listClass = list.getClass();
        Method addMethod = listClass.getDeclaredMethod("add",Object.class);
        addMethod.invoke(list,"wlelelee");
    }
}