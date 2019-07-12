package 刘文杰homework_old.hmk_0620;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Question5 {
    public static void main(String[] args) throws Exception{
        Set<Integer> set = new HashSet<>();
        set.add(11);
        set.add(22);

        Class<? extends Collection> arrayClass = set.getClass();
        Method addMethod = arrayClass.getMethod("add", Object.class);
        addMethod.invoke(set, "Test");
        System.out.println(set);
    }
}
