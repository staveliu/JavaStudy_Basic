package 刘文杰homework_old.hmk_0618.L181201;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class CountSingleFile {
    public static void main(String[] args) throws Exception{
        String dataPath = "./0618/上课代码/adv11/题目/data.txt";
        File file = new File(dataPath);

        //定义计数器变量 lineCount:行数,noteCount:注释行数,nullCount:空行数,ch:字符数
        int lineCount = 0;
        int noteCount = 0;
        int nullCount = 0;
        int ch = 0;

        //定义变量记录每行开始的位置
        int lineStart = 0;

        //初始化26个字母的map
        Map<Character,Integer> c = new HashMap<>();
        for (char i='A';i<='Z';i++){
            c.put(i,0);
        }

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

        //计算百分比
        float codeLinePercent = (((float)lineCount-(float)nullCount-(float)noteCount)/(float)lineCount)*100;
        float notePercent = ((float)noteCount/(float)lineCount)*100;
        float nullPercent = ((float)nullCount/(float)lineCount)*100;

        //构造输出到out.txt的内容为字符串
        String writeData = "总行数："+lineCount+"\n"
                            +"代码行："+codeLinePercent+"%\n"
                            +"注释行："+notePercent+"%\n"
                            +"空行："+nullPercent+"%\n"
                            +"字符数："+ch+"\n";
        for (char i = 'A'; i<='Z'; i++){
            writeData = writeData + i + " : "+(float)c.get(i)/(float)ch*100 + "\n";
        }

        //输出writeData到out.txt
        String outPath = "./0618/上课代码/adv11/题目/out.txt";
        File outFile = new File(outPath);
        FileOutputStream fos = new FileOutputStream(outFile);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF(writeData);
    }
}
