package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Author> authorsTable = Arrays.asList(
                new Author(1, "Author_1"),
                new Author(2, "Author_2"),
                new Author(3, "Author_3"),
                new Author(4, "Author_4"),
                new Author(5, "Author_5")
        );

        List<Book> booksTable = Arrays.asList(
                new Book(1, "Book_1", 1),
                new Book(2, "Book_2", 1),                
                new Book(3, "Book_3", 2),               
                new Book(4, "Book_4", 3),
                new Book(5, "Book_5", 3),
                new Book(6, "Book_6", 3),               
                new Book(7, "Book_7", 4),
                new Book(8, "Book_8", 5),
                new Book(9, "Book_9", 5)                
        );
        
        List<ResultRow> resultNLJ = Joins.nestedLoopJoin(authorsTable, booksTable);
        System.out.println("Nested Loop Join: " + resultNLJ);
        
        System.out.println();
        List<ResultRow> resultHJ = Joins.hashJoin(authorsTable, booksTable);
        System.out.println("Hash Join: " + resultHJ);
        
        System.out.println();
        List<ResultRow> resultSMJ = Joins.sortMergeJoin(authorsTable, booksTable);
        System.out.println("Sort Merge Join: " + resultSMJ);
    }
}