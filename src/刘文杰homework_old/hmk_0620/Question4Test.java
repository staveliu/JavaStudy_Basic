package 刘文杰homework_old.hmk_0620;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Question4Test {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<>();
		list.add(123);
		list.add(12);
		list.add(2424);

		Map<String,Integer> map = new HashMap<>();
		map.put("Str1",2324);
		map.put("Str2",232);
		map.put("Str3",324);
		map.put("Str4",24);

		System.out.println(Question4.maxAndMin(list));
		System.out.println(Question4.maxAndMin(map.values()));
	}

}
