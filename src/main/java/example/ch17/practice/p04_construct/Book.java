package example.ch17.practice.p04_construct;

public class Book {
    String title; //제목
    String author; //저자
    int page; //페이지 수

    //코드 완성
    Book() {
        this("","",0);
    }

    Book(String title, String author) {
        this(title, author, 0);
    }

    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    void displayInfo() {
        System.out.println("title = " + title+", author = " + author+", page = " + page);
    }
}
