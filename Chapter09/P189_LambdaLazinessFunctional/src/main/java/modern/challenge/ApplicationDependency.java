package modern.challenge;

import java.util.function.Supplier;

public class ApplicationDependency {
    
    private final long id;
    private final String name;        
    private final Supplier<String> dependencies 
            = Memoize.supplier(this::downloadDependencies);

    public ApplicationDependency(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }   
    
    public String getDependencies() {
        return dependencies.get();
    }   
    
    private String downloadDependencies() {
           
        return "list of dependencies downloaded from repository " + Math.random();
    }    
}