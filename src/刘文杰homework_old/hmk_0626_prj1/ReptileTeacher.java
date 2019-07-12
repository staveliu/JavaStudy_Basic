package 刘文杰homework_old.hmk_0626_prj1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ReptileTeacher implements Runnable{
    private String url;

    public ReptileTeacher(String page) {
        this.url = page;
    }

    @Override
    public void run(){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Elements list = doc.select(".k12-gl-gslb-3nf1-1-01-left dl");
            for (Element e:list){
                String teacherUrl = e.selectFirst("a").attr("href");
                Document teacherDoc = Jsoup.connect(teacherUrl).get();
                Element ele = teacherDoc.selectFirst(".zjtd");
                String name = ele.selectFirst("h2").text().replace(ele.selectFirst("h2").selectFirst("span").text(),"").replace(" ","");
                String career = ele.selectFirst("h2").selectFirst("span").text();
                String picUrl = ele.selectFirst("img").attr("src");
                String intro = ele.selectFirst("dd").text().replaceAll("<.*>"," ");;
                Teacher teacher = new Teacher(name,career,picUrl,intro);
                TeacherController tc = new TeacherController(teacher);
                tc.add();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
