package 刘文杰homework_old.hmk_0626_prj1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    /**
     * Configuration
     * maxSQLThread 最大数据库插入并发
     * maxReptileThread 最大爬虫线程
     * maxDownloadThread 最大图片下载线程
     * sql_addr 数据库连接地址
     * sql_port 数据库连接端口
     * sql_usr  数据库用户名
     * sql_pwd  数据库密码
     * sql_data 数据库库名
     */

    static final int maxSQLThread = 20;
    static final int maxReptileThread = 3;
    static final int maxDownloadThread = 5;
    static final String sql_addr = "45.32.249.128";
    static final int sql_port = 3306;
    static final String sql_usr = "root";
    static final String sql_pwd = "153007lwj";
    static final String sql_data = "bank";


    static ExecutorService sqlPool = Executors.newFixedThreadPool(maxSQLThread);
    static ExecutorService mainPool = Executors.newFixedThreadPool(maxReptileThread);
    static ExecutorService downloadPool = Executors.newFixedThreadPool(maxDownloadThread);

    public static void main(String[] args) throws Exception{
        List<String> pages = new LinkedList<>();

        pages.add("http://www.newer2001.com/help_szll.html");
        pages.add("http://www.newer2001.com/help_szll_0002.html");
        pages.add("http://www.newer2001.com/help_szll_0003.html");

        for (String page:pages){
            mainPool.execute(new ReptileTeacher(page));
        }
        mainPool.shutdown();
    }
}
