package modern.challenge;

public class ApplicationDependency {

    private final long id;
    private final String name;
    private String dependencies;

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

        if (dependencies == null) {
            downloadDependencies();
        }

        return dependencies;
    }

    private void downloadDependencies() {

        dependencies = "list of dependencies downloaded from repository " + Math.random();
    }
}
