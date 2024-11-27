package crs;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private List<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(String title, double price) {
        Book book = new Book(title, this, price);
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void getInfo() {
        System.out.println("Autor: " + this.name);
        System.out.println("Libros:");
        for (Book book : books) {
            book.getInfo();
        }
    }

    public String getName() {
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
}