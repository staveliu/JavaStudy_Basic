package Advanced.adv1;


import java.io.*;
import java.util.Optional;

public class FileDemo1 {
    public static void main(String[] args){
        File file = new File("stave.iml");

        File file2 = new File("Stave2.txt");
        if (!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file2);
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[(int)file.length()];
            try {
                fis.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.write(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
