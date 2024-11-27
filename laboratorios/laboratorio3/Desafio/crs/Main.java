package crs;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Gabriel García Márquez");

        author.addBook("Cien años de soledad", 19.99);
        author.addBook("El amor en los tiempos del cólera", 15.50);

        Book book = new Book("Crónica de una muerte anunciada", author, 10.99);
        author.addBook(book);

        author.getInfo();
    }
}
