package modern.challenge.zipper;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public final class ZipNode<T extends Zippable> implements Zippable {

    private static final Zippable[] DUMMY = new Zippable[0];

    private final T node;        // wrap the original tree node
    private Zippable[] children; // list of children for this node

    // wrap a ZipNode without children    
    protected ZipNode(final T node) {
        this(node, DUMMY);
    }

    // wrap a ZipNode and its children    
    protected ZipNode(final T node, Zippable[] children) {

        if (node == null) {
            throw new IllegalArgumentException("The given node cannot be null");
        }

        if (node instanceof ZipNode<?>) {
            throw new IllegalArgumentException("The given node is already zipped");
        }

        if (children == null) {
            children = new Zippable[0];
        }

        this.node = node;
        this.children = children;
    }

    @Override
    public Collection<? extends Zippable> getChildren() {
        lazyGetChildren();
        return (children != null) ? new LinkedList<>(Arrays.asList(children)) : null;
    }

    // return the original node
    public T unwrap() {
        return node;
    }

    public boolean isLeaf() {
        lazyGetChildren();
        return children == null || children.length == 0;
    }

    public boolean hasChildren() {
        lazyGetChildren();
        return children != null && children.length > 0;
    }

    protected Zippable[] children() {
        lazyGetChildren();
        return children;
    }

    protected ZipNode<T> replaceNode(final T node) {
        lazyGetChildren();
        return new ZipNode<>(node, children);
    }

    // lazy initialization of children
    private void lazyGetChildren() {

        if (children == DUMMY) {
            Collection<? extends Zippable> nodeChildren = node.getChildren();
            children = (nodeChildren == null) ? null : nodeChildren.toArray(Zippable[]::new);
        }
    }

    @Override
    public String toString() {
        return node.toString(); // call the original toString()
    }
}
