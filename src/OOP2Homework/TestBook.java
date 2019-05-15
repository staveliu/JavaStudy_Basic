package OOP2Homework;

public class TestBook {
    public static void main(String[] args){
        Book book1 = new Book("《Java面向对象编程》","张三","电子科技出版社",32.0f);
        Book book2 = new Book("《Java Swing程序设计》","李四","机械工业出版社",46.0f);
        Book book3 = new Book("《高级Java网络编程》","王五","北京邮电出版社",54.0f);

        book1.description();
        book2.description();
        book3.description();
    }
}
