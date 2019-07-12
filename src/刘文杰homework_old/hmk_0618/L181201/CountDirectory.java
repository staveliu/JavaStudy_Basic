package 刘文杰homework_old.hmk_0618.L181201;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountDirectory {

    public Map<Character, Integer> getC() {
        return c;
    }

    private Map<Character,Integer> c = new HashMap<>();

    public void init(){
        //初始化26个字母的map
        for (int i=65;i<=90;i++){
            c.put((char)i,0);
        }
    }
    public void countFile(File file) throws Exception{

        //定义计数器变量 lineCount:行数,noteCount:注释行数,nullCount:空行数,ch:字符数
        int lineCount = 0;
        int noteCount = 0;
        int nullCount = 0;
        int ch = 0;

        //定义变量记录每行开始的位置
        int lineStart = 0;

        //读取文件数据
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()+1];
        data[(int)file.length()]=0;
        fis.read(data);
        ch = (int)file.length();

        //开始统计
        for (int i=0;i<data.length;i++) {
            if ((char)data[i] == '\n') {
                lineCount++;
                String substr="";
                for (int j = lineStart;j<=i;j++){
                    substr = substr + (char)data[j];
                }
                if (substr.contains("//") || substr.contains("/*") || substr.contains("*/") || substr.contains("  *")) {
                    noteCount++;
                }
                lineStart = i + 1;
            }

            if ((char)data[i] == '\n' && (char)data[i + 1] == '\n') {
                nullCount++;
            }

            if (data[i] >= 65 && data[i] <= 90) {
                c.put((char)data[i], c.get((char)data[i]) + 1);
            }
            if (data[i] >= 97 && data[i] <= 122) {
                c.put((char)(data[i]-32), c.get((char)(data[i]-32))+1);
            }
        }

        //字符1，2，3，4，5分别代表行数、代码行数、注释行数、空行数、字符数，方便return
        c.put('1',c.get('1')+lineCount);
        c.put('2',c.get('2')+lineCount-nullCount-noteCount);
        c.put('3',c.get('3')+noteCount);
        c.put('4',c.get('4')+nullCount);
        c.put('5',c.get('5')+ch);

    }

    public void getFile(File directory){
        File[] files = directory.listFiles();
        for (File file:files){
            if (file.isFile()){
                try {
                    countFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if(file.isDirectory())
                this.getFile(file);
            }
        }
    }
    public static void main(String[] args){
        CountDirectory count = new CountDirectory();
        count.init();
        File dataFile = new File("./0617/");
        count.getFile(dataFile);
        Map<Character, Integer> dataRev = count.getC();

        float codeLinePercent = ((float)dataRev.get('2')/(float)dataRev.get('1'))*100;
        float notePercent = ((float)dataRev.get('3')/(float)dataRev.get('1'))*100;
        float nullPercent = ((float)dataRev.get('4')/(float)dataRev.get('1'))*100;

        //构造输出到out.txt的内容为字符串
        String writeData = "总行数："+(float)dataRev.get('1')+"\n"
                +"代码行："+codeLinePercent+"%\n"
                +"注释行："+notePercent+"%\n"
                +"空行："+nullPercent+"%\n"
                +"字符数："+(float)dataRev.get('5')+"\n";
        Set<Character> chlist = dataRev.keySet();
        for (char i = 'A'; i<='Z'; i++){
            writeData = writeData + i + " : "+(float)dataRev.get(i)/(float)dataRev.get('5')*100 + "\n";
        }

        //输出writeData到out.txt
        String outPath = "./0618/上课代码/adv11/题目/out.txt";
        File outFile = new File(outPath);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(writeData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
