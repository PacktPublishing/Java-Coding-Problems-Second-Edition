package modern.challenge.record;

import java.util.List;

public record Author(String name,  String genre, List<Book> books) {}
