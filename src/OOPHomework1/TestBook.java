package OOPHomework1;

public class TestBook {
    public static void main(String[] args){
        Book book1 = new Book();
        book1.title = "《Java面向对象编程》";
        book1.author = "张三";
        book1.publisher = "电子科技出版社";
        book1.prize = 32.0f;
        Book book2 = new Book();
        book2.title = "《Java Swing程序设计》";
        book2.author = "李四";
        book2.publisher = "机械工业出版社";
        book2.prize = 46.0f;
        Book book3 = new Book();
        book3.title = "《高级Java网络编程》";
        book3.author = "王五";
        book3.publisher = "北京邮电出版社";
        book3.prize = 54.0f;
        book1.description();
        book2.description();
        book3.description();
    }
}
