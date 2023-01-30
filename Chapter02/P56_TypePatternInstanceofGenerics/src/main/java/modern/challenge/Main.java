package modern.challenge;

import java.util.EnumMap;
import java.util.Map;

public class Main {

    enum Status {
        DRAFT, READY
    }
    
    static class Book { 
        public void review() { System.out.println("reviewing ..."); };                 
        public void print() { System.out.println("printing ..."); }; 
    }

    public static <K, V> void processOld(Map<K, ? extends V> map) {
        if (map instanceof EnumMap<?, ? extends V>) {
            EnumMap<?, ? extends V> books = (EnumMap<?, ? extends V>) map;
            if (books.get(Status.DRAFT) instanceof Book) {
                Book book = (Book) books.get(Status.DRAFT);
                book.review();
            }
        }
    }

    public static <K, V> void processNew(Map<K, ? extends V> map) {
        if (map instanceof EnumMap<?, ? extends V> books
                && books.get(Status.DRAFT) instanceof Book book) {
            book.review();
        }
    }

    public static void main(String[] args) {

        EnumMap<Status, Book> books = new EnumMap<>(Status.class);

        books.put(Status.DRAFT, new Book());
        books.put(Status.READY, new Book());

        processOld(books);
        processNew(books);
    }
}
