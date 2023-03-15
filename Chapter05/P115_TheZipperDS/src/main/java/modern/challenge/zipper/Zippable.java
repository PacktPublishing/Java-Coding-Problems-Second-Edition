package modern.challenge.zipper;

import java.util.Collection;

public interface Zippable {
    
    public Collection<? extends Zippable> getChildren();
}
