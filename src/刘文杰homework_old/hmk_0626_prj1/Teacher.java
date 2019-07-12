package 刘文杰homework_old.hmk_0626_prj1;

public class Teacher {
    private String name;
    private String career;
    private String picUrl;
    private String intro;

    public Teacher() {
    }

    public Teacher(String name, String career, String picUrl, String intro) {
        this.name = name;
        this.career = career;
        this.picUrl = picUrl;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
