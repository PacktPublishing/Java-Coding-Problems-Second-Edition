package modern.challenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked") 
public final class Joins {

    private Joins() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<ResultRow> nestedLoopJoin(
            List<Author> authorsTable, List<Book> booksTable) {

        if (authorsTable == null || booksTable == null) {
            return Collections.emptyList();
        }

        List<ResultRow> resultSet = new LinkedList();

        for (Author author : authorsTable) {
            for (Book book : booksTable) {
                if (book.authorId() == author.authorId()) {
                    resultSet.add(new ResultRow(
                            author.authorId(), author.name(), book.title(), book.bookId()));
                }
            }
        }

        return resultSet;
    }

    public static List<ResultRow> hashJoin(
            List<Author> authorsTable, List<Book> booksTable) {

        if (authorsTable == null || booksTable == null) {
            return Collections.emptyList();
        }

        Map<Integer, Author> authorMap = new HashMap<>();

        for (Author author : authorsTable) {
            authorMap.put(author.authorId(), author);
        }

        List<ResultRow> resultSet = new LinkedList();

        for (Book book : booksTable) {
            Integer authorId = book.authorId();
            Author author = authorMap.get(authorId);

            if (author != null) {
                resultSet.add(new ResultRow(
                        author.authorId(), author.name(), book.title(), book.bookId()));
            }
        }

        return resultSet;
    }

    public static List<ResultRow> sortMergeJoin(
            List<Author> authorsTable, List<Book> booksTable) {

        if (authorsTable == null || booksTable == null) {
            return Collections.emptyList();
        }

        authorsTable.sort(Comparator.comparing(Author::authorId));

        booksTable.sort((b1, b2) -> {
            int sortResult = Comparator
                    .comparing(Book::authorId)
                    .compare(b1, b2);

            return sortResult != 0 ? sortResult : Comparator
                    .comparing(Book::bookId)
                    .compare(b1, b2);
        });

        List<ResultRow> resultSet = new LinkedList();

        int authorCount = authorsTable.size();
        int bookCount = booksTable.size();
        int p = 0;
        int q = 0;

        while (p < authorCount && q < bookCount) {
            Author author = authorsTable.get(p);
            Book book = booksTable.get(q);

            if (author.authorId() == book.authorId()) {
                resultSet.add(new ResultRow(
                        author.authorId(), author.name(), book.title(), book.bookId()));
                q++;
            } else {
                p++;
            }
        }

        return resultSet;
    }
}
