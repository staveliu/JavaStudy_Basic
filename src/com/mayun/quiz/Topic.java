package com.mayun.quiz;

import java.util.Date;

public class Topic extends Tip {
    private int id;
    private int boardId;

    public Topic(int id, int boardId) {
        this.id = id;
        this.boardId = boardId;
    }

    public Topic(String title, String content, Date publishTime, int uid, int id, int boardId) {
        super(title, content, publishTime, uid);
        this.id = id;
        this.boardId = boardId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
}
