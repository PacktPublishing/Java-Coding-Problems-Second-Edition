package modern.challenge;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Author {

    private final String name;
    private final List<Book> books;

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void bookshelfGt2005(Consumer<Bookshelf> consumer) {

        for (Book book : this.getBooks()) {
            if (book.getPublished().getYear() > 2005) {
                consumer.accept(new Bookshelf(this.getName(), book.getTitle()));
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.books);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.books, other.books);
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + ", books=" + books + '}';
    }
}
