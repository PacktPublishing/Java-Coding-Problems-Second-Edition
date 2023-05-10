package modern.challenge;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.entry;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        List<Post> posts = List.of(
                new Post(1, "Running jOOQ", "#database #sql #rdbms"),
                new Post(2, "I/O files in Java", "#io #storage #rdbms"),
                new Post(3, "Hibernate Course", "#jpa #database #rdbms"),
                new Post(4, "Hooking Java Sockets", "#io #network"),
                new Post(5, "Analysing JDBC transactions", "#jdbc #rdbms")
        );

        Map<String, List<Integer>> result = posts.stream()
                .flatMap(post -> Post.allTags(post).stream()
                .map(t -> entry(t, post.getId())))
                .collect(groupingBy(Entry::getKey,
                        mapping(Entry::getValue, toList())));

        System.out.println(result);

        Map<String, List<Integer>> resultMulti = posts.stream()
                .<Map.Entry<String, Integer>>mapMulti((post, consumer) -> {
                    for (String tag : Post.allTags(post)) {
                        consumer.accept(entry(tag, post.getId()));
                    }
                })
                .collect(groupingBy(Entry::getKey,
                        mapping(Entry::getValue, toList())));

        System.out.println(resultMulti);
    }
}
