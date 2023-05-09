package modern.challenge;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    
    private final String title;
    private final LocalDate published;

    public Book(String title, LocalDate published) {
        this.title = title;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublished() {
        return published;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.published);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.published, other.published);
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", published=" + published + '}';
    }        
}
