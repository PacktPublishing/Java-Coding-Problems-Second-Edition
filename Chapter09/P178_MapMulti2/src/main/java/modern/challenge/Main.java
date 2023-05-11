package modern.challenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("Book1", LocalDate.of(2000, 3, 12));
        Book b2 = new Book("Book2", LocalDate.of(2002, 3, 11));
        Book b3 = new Book("Book3", LocalDate.of(2004, 11, 24));
        Book b4 = new Book("Book4", LocalDate.of(2002, 6, 10));
        Book b5 = new Book("Book5", LocalDate.of(2009, 5, 7));
        Book b6 = new Book("Book6", LocalDate.of(2007, 2, 17));
        Book b7 = new Book("Book7", LocalDate.of(1995, 10, 27));
        Book b8 = new Book("Book8", LocalDate.of(2001, 10, 17));
        Book b9 = new Book("Book9", LocalDate.of(2004, 8, 10));
        Book b10 = new Book("Book10", LocalDate.of(2008, 1, 4));

        Author a1 = new Author("Joana Nimar", List.of(b1, b2, b3));
        Author a2 = new Author("Olivia Goy", List.of(b4, b5));
        Author a3 = new Author("Marcel Joel", List.of(b6));
        Author a4 = new Author("Alexender Tohn", List.of(b7, b8, b9, b10));

        List<Author> authors = new ArrayList<>();
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);

        List<Bookshelf> bookshelfClassic = authors.stream()
                .flatMap(
                        author -> author.getBooks()
                                .stream()
                                .map(book -> new Bookshelf(author.getName(), book.getTitle()))
                )
                .collect(Collectors.toList());

        System.out.println(bookshelfClassic);
        System.out.println();

        List<Bookshelf> bookshelfMM = authors.stream()
                .<Bookshelf>mapMulti((author, consumer) -> {
                    for (Book book : author.getBooks()) {
                        consumer.accept(new Bookshelf(author.getName(), book.getTitle()));
                    }
                })
                .collect(Collectors.toList());

        System.out.println(bookshelfMM);
        System.out.println();

        /* Case 1: mapMulti() is useful when replacing each stream 
        element with a small (possibly zero) number of elements */
        
        List<Bookshelf> bookshelfGt2005Classic = authors.stream()
                .flatMap(
                        author -> author.getBooks()
                                .stream()
                                .filter(book -> book.getPublished().getYear() > 2005)
                                .map(book -> new Bookshelf(author.getName(), book.getTitle()))
                )
                .collect(Collectors.toList());

        System.out.println();
        System.out.println(bookshelfGt2005Classic);

        List<Bookshelf> bookshelfGt2005MM1 = authors.stream()
                .<Bookshelf>mapMulti((author, consumer) -> {
                    for (Book book : author.getBooks()) {
                        if (book.getPublished().getYear() > 2005) {
                            consumer.accept(new Bookshelf(author.getName(), book.getTitle()));
                        }
                    }
                })
                .collect(Collectors.toList());

        System.out.println();
        System.out.println(bookshelfGt2005MM1);

        /* Case 2: mapMulti() is useful when it is easier to use an imperative approach 
        for generating result elements than it is to return them in the form of a Stream */
        
        List<Bookshelf> bookshelfGt2005MM2 = authors.stream()
                .<Bookshelf>mapMulti(Author::bookshelfGt2005)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println(bookshelfGt2005MM2);        
    }
}