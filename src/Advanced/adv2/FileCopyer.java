package Advanced.adv2;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyer {
    public static void main(String[] args) {
        try {
            copy("./stave.iml", "./stave3.iml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(String f1, String f2) throws Exception {
        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2);
        char[] chars = new char[1024];
        int len = fr.read(chars);
        while (len != -1) {
            fw.write(chars, 0, len);
            fw.flush();
            len = fr.read(chars);
        }
        fr.close();
        fw.close();
    }
}
