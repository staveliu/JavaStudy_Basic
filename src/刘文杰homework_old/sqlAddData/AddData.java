package 刘文杰homework_old.sqlAddData;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class AddData {
    private int empNum;
    private int prodNum;
    private int salesNum;



    public AddData(int empNum, int prodNum, int salesNum) {
        this.empNum = empNum;
        this.prodNum = prodNum;
        this.salesNum = salesNum;
    }

    public void add(){
        SQLClass sql = new SQLClass("45.32.249.128",3306,"root","153007lwj","sales");
        sql.createConn();
        Random rand = new Random();
        for (int i=0;i<empNum;i++){
            int nameRand = rand.nextInt(5);
            String[] nameGroup = {"李云","孙一成","林笑",NameBuilder.build(),NameBuilder.build()};
            String name = nameGroup[nameRand];
            int sex = rand.nextInt(2);
            int age = rand.nextInt(10)+18;
            String addrRand = getChinese(5);
            //city
            int cityRand = rand.nextInt(7);
            String[] citys = {"长沙","郴州","株洲","岳阳","衡阳","永州","怀化"};
            String city = citys[cityRand];
            //tel
        }
    }

    public static String getChinese(long seed) {
        String str=null;
        int highpos,lowpos;
        Random random=new Random(seed);
        highpos=(176+Math.abs(random.nextInt(39)));
        lowpos=(161+Math.abs(random.nextInt(93)));
        byte[] bb=new byte[2];
        bb[0]=new Integer(highpos).byteValue();
        bb[1]=new Integer(lowpos).byteValue();
        try {
            str=new String(bb,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
