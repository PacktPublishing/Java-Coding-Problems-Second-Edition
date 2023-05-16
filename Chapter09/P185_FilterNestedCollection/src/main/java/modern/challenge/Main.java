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

        /* find books published in 2002 */
        // using flatMap
        List<Book> book2002fm = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .filter(book -> book.getPublished().getYear() == 2002)
                .collect(Collectors.toList());

        System.out.println(book2002fm);
        System.out.println();

        // using mapMulti
        List<Book> book2002mm = authors.stream()
                .<Book>mapMulti((author, consumer) -> {
                    for (Book book : author.getBooks()) {
                        if (book.getPublished().getYear() == 2002) {
                            consumer.accept(book);
                        }
                    }
                })
                .collect(Collectors.toList());

        System.out.println(book2002mm);
        System.out.println();

        /* find authors having book published in 2002 */
        // using anyMatch
        List<Author> authors2002am = authors.stream()
                .filter(
                        author -> author.getBooks().stream()
                                .anyMatch(book -> book.getPublished().getYear() == 2002)
                )
                .collect(Collectors.toList());

        System.out.println(authors2002am);
        System.out.println();

        // using mapMulti
        List<Author> author2002mm = authors.stream()
                .<Author>mapMulti((author, consumer) -> {
                    for (Book book : author.getBooks()) {
                        if (book.getPublished().getYear() == 2002) {
                            consumer.accept(author);
                            break;
                        }
                    }
                })
                .collect(Collectors.toList());

        System.out.println(author2002mm);
        System.out.println();

        // using removeif (altering the original list)
        authors.removeIf(author -> author.getBooks().stream()
                .noneMatch(book -> book.getPublished().getYear() == 2002));

        System.out.println(authors);
    }
}
