package modern.challenge.tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import modern.challenge.zipper.Zippable;

public class Node implements Zippable {

    private final String name;
    private final List<Node> children;

    public Node(final String name, final Node... children) {

        if (name == null) {
            throw new IllegalArgumentException("The given name cannot be null");
        }
                
        this.name = name;
        this.children = new LinkedList<>(Arrays.asList(children));
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<Node> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        return "Node{" + "name=" + name + ", children=" + children + '}';
    }        
}