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
                new Post(2, "Reading/writing files in Java", "#io #storage #rdbms"),
                new Post(3, "Working with Hibernate", "#jpa #database #rdbms"),
                new Post(4, "Hooking Java Sockets", "#io #network"),
                new Post(5, "Analysing JDBC transactions", "#jdbc #rdbms")
        );

        Map<String, List<Integer>> result = posts.stream()
                .flatMap(post -> Post.allTags(post).stream()
                        .map(p -> entry(p, post.getId())))
                .collect(groupingBy(Entry::getKey, 
                        mapping(Entry::getValue, toList())));

        System.out.println(result);               
    }
}