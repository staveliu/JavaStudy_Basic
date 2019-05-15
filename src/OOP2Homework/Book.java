package OOP2Homework;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private Float prize;

    public Book(String title, String author, String publisher, Float prize) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.prize = prize;
    }
    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Float getPrize() {
        return prize;
    }

    public void setPrize(Float prize) {
        this.prize = prize;
    }

    public void description(){
        System.out.println(title+"\t"+author+"\t"+publisher+"\t"+prize);
    }
}
