package com.mayun.quiz;

import java.util.Date;

public class Tip {
    private String title;
    private String content;
    private Date publishTime;

    @Override
    public String toString() {
        return "Tip{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", uid=" + uid +
                '}';
    }
    public void getInfo(){
        System.out.println(toString());
    }

    private int uid;

    public Tip() {
    }

    public Tip(String title, String content, Date publishTime, int uid) {
        this.title = title;
        this.content = content;
        this.publishTime = publishTime;
        this.uid = uid;
   }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
