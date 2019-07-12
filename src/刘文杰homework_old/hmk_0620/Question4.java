package 刘文杰homework_old.hmk_0620;

import java.util.Collection;
import java.util.Iterator;

public class Question4 {
    public static <T extends Comparable<T>> Pair<T> maxAndMin(Collection<T> aggre) {
        Iterator<T> it = aggre.iterator();
        T first = it.next();
        T max = first;
        T min = first;
        while (it.hasNext()) {
            T nextOne = it.next();
            if (nextOne.compareTo(max) > 0) {
                max = nextOne;
            }
            if (nextOne.compareTo(min) < 0) {
                min = nextOne;
            }
        }
        return new Pair<T>(max, min);
    }
}
