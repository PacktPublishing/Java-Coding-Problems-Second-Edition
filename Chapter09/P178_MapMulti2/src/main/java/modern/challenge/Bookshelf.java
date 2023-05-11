package modern.challenge;

public class Bookshelf {

    private final String author;
    private final String book;

    public Bookshelf(String author, String book) {
        this.author = author;
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public String getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Shelf{" + "author=" + author + ", book=" + book + '}';
    }
}
