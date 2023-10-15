package modern.challenge;

import java.util.HashMap;
import java.util.Map;

public class DependencyManager {
    
    private Map<Long,String> apps = new HashMap<>();
    
    public void processDependencies(ApplicationDependency appd){
        
        System.out.println();
        System.out.println("Processing app: " + appd.getName());
        System.out.println("Dependencies: " + appd.getDependencies());
        
        apps.put(appd.getId(),appd.getDependencies());        
    }    
}
