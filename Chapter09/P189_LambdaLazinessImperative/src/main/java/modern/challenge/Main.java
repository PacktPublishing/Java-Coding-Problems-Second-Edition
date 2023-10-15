package modern.challenge;

public class Main {

    public static void main(String[] args) {

        ApplicationDependency app1  = new ApplicationDependency(1, "app-1");
        ApplicationDependency app2  = new ApplicationDependency(2, "app-2");
        
        DependencyManager dm = new DependencyManager();
        dm.processDependencies(app1);
        dm.processDependencies(app2);
    }    
}