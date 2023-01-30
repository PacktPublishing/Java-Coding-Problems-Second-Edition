package modern.challenge;

import java.util.HashMap;
import java.util.Map;

public class Main {
    
    interface Status {}    
    static class Outline implements Status { void write() {}; }
    static class Draft implements Status { void review() {}; }
    static class Ready implements Status { void print() {}; }

    static class Book {

        private static final Map<Integer, Status> chapters = new HashMap<>();

        public static void addChapter(Integer nr, Status status) {
            chapters.putIfAbsent(nr, status);
        }

        public Map<Integer, Status> getChapters() {
            return chapters;
        }
    }

    public static void main(String[] args) {
        Book.addChapter(1, new Outline());
        Book.addChapter(2, new Draft());
        Book.addChapter(3, new Outline());
        Book.addChapter(4, new Ready());

        if (Book.chapters instanceof Map<?, Status>) {
            Map<?, Status> chapters = (Map<?, Status>) Book.chapters;
            if (!chapters.isEmpty()) {
                Status status = chapters.get(1);
                if (status instanceof Outline) {
                    Outline x = (Outline) status;
                    System.out.println("writing ...");
                    x.write();
                }
            }
        }
        
        if (Book.chapters instanceof Map<?, Status> chapters
                && !chapters.isEmpty() && chapters.get(1) instanceof Outline chapter) {
            System.out.println("writing ...");
            chapter.write();
        }
    }
}