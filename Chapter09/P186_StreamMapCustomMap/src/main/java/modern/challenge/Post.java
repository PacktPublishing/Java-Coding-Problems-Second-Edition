package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Post {
    
    private final int id;
    private final String title;
    private final String tags;

    public Post(int id, String title, String tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tags;
    }
            
    public static List<String> allTags(Post post) {
        
        return Arrays.asList(post.getTags().split("#"));
    }
}
