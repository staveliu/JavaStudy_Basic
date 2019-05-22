package oop_poly_hmk.onlineexam;

public class Question {
    private int number;
    private String content;
    private char[] choice = {'A','B','C','D'};

    public Question(int number, String content) {
        this.number = number;
        this.content = content;

    }

    public Question() {
    }
    public void showQuestion(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public char[] getChoice() {
        return choice;
    }

    public void setChoice(char[] choice) {
        this.choice = choice;
    }

    public boolean checkAnswer(String answer){
        return false;
    }
}
