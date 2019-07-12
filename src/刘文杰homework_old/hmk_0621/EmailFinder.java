
package 刘文杰homework_old.hmk_0621;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFinder {
    public static void main(String[] args) throws Exception {
        File fileHtml = new File("./demo.htm");
        File out = new File("./out.txt");
        out.createNewFile();
        BufferedReader reader = new BufferedReader(new FileReader(fileHtml));
        BufferedWriter dos = new BufferedWriter(new FileWriter(out));
        String line;
        String regex = "[a-zA-Z0-9_-|.]+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        Pattern p = Pattern.compile(regex);
        while((line = reader.readLine()) != null) {
            Matcher matcher = p.matcher(line);
            while(matcher.find()) {
                dos.write(matcher.group()+"\n");
            }
        }
        dos.close();
        reader.close();
    }

}
