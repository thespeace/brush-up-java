package example.ch17.practice.p10_extends.ex;

public class Book extends Item{

    private String author;
    private String isbn; // 책 번호

    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 저자 : " + author + ", isbn : " + isbn);
    }
}
