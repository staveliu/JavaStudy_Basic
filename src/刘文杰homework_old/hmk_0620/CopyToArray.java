package 刘文杰homework_old.hmk_0620;

import java.util.Collection;

public class CopyToArray {
    private static <T> void copy(Collection<T> source, T[] dest) {
        int i = 0;
        for (T ele : source) {
            dest[i++] = ele;
        }
    }
}
