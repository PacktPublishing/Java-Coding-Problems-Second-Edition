package modern.challenge.zipper;

import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public final class Cursor<T extends Zippable> {

    private final ZipNode<T> zipNode; // this is a zip node wrapping your node (original node)   
    private final ZipperRange range;

    protected Cursor(final ZipNode<T> zipNode, final ZipperRange range) {

        this.zipNode = zipNode;
        this.range = range;
    }

    public ZipNode<T> zipNode() {
        return zipNode;
    }

    public T unwrap() {
        return zipNode.unwrap();
    }

    public Iterator<T> childrenIterator() {

        if (isLeaf()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the leaf nodes");
        }

        final Iterator<? extends Zippable> iterator = zipNode.getChildren().iterator();
        return new Iterator<T>() {
            
            @Override
            public T next() {
                Zippable zipNode = iterator.next();
                return (zipNode instanceof ZipNode<?>) ? ((ZipNode<T>) zipNode).unwrap() : (T) zipNode;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(
                        "This operation is not supported");
            }
            
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }
        };
    }
    
    public boolean hasChildren() {
        return zipNode.hasChildren();
    }

    public boolean isRoot() {
        return range.isRoot();
    }

    public boolean isFirst() {
        return range.isFirst();
    }

    public boolean isLast() {
        return range.isLast();
    }

    public boolean isEnd() {

        if (hasChildren() || !isLast()) {
            return false;
        } else {
            Cursor<T> upZipNode = this;
            while (upZipNode.isLast() && !upZipNode.isRoot()) {
                upZipNode = upZipNode.up();
            }
            return upZipNode.isRoot();
        }
    }

    public boolean isLeaf() {
        return zipNode.isLeaf();
    }    

    /* API for navigating the zip-tree */
    public Cursor<T> up() {

        if (isRoot()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the root zip node");
        }

        return new Cursor<>(new ZipNode<>((T) range.getParentZipNode().unwrap(),
                shallowCopyUp()),
                range.getParentRange());
    }

    public Cursor<T> down(int index) {

        if (!hasChildren() || index > zipNode.children().length || index < 0) {
            throw new UnsupportedOperationException(
                    "This operation is not supported if the zip node doesn't "
                    + "have children or the index is larger than the number of children or less than 0");
        }

        return new Cursor<>(toZipNode(zipNode.children()[index]), shallowCopyDown(index));
    }

    public Cursor<T> down() {
        return down(0);
    }

    public Cursor<T> right() {

        if (isLast()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the most-right zip node");
        }

        return new Cursor<>(toZipNode(range.rightSiblings()[0]), shallowCopyRight());
    }

    public Cursor<T> left() {

        if (isFirst()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the most-left zip node");
        }

        int leftlen = range.leftSiblings().length - 1;

        return new Cursor<>(toZipNode(range.leftSiblings()[leftlen]), shallowCopyLeft(leftlen));
    }

    public Cursor<T> rightMost() {

        Cursor<T> currentZipNode = this;

        while (!currentZipNode.isLast()) {
            currentZipNode = currentZipNode.right();
        }

        return currentZipNode;
    }

    public Cursor<T> leftMost() {

        Cursor<T> currentZipNode = this;

        while (!currentZipNode.isFirst()) {
            currentZipNode = currentZipNode.left();
        }

        return currentZipNode;
    }

    public Cursor<T> root() {

        Cursor<T> currentZipNode = this;

        while (!currentZipNode.isRoot()) {
            currentZipNode = currentZipNode.up();
        }

        return currentZipNode;
    }    

    /* API for manipulating the zip-tree */
    public Cursor<T> add(final T... zipNodes) {

        if (isLeaf()) {
            throw new UnsupportedOperationException("This operation is not supported for leaf nodes");
        }
        
        if(zipNodes == null || zipNodes.length == 0) {
            throw new IllegalArgumentException("The given zip nodes cannot be null or empty");
        }

        return new Cursor<>(new ZipNode<>(unwrap(), shallowCopyAdd(zipNodes)), range);
    }

    public Cursor<T> addAll(final Collection<T> zipNodes) {
        return add((T[]) zipNodes.toArray());
    }   

    public Cursor<T> clear() {

        if (isLeaf()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for leaf nodes");
        }

        return new Cursor<>(new ZipNode<>(unwrap(), new Zippable[0]), range);
    }

    public Cursor<T> insertLeft(T... zipNodes) {
        
        if(zipNodes == null || zipNodes.length == 0) {
            throw new IllegalArgumentException("The given zip nodes cannot be null or empty");
        }

        return new Cursor<>(zipNode, shallowCopyInsertLeft(zipNodes));
    }

    public Cursor<T> insertRight(T... zipNodes) {
        
        if(zipNodes == null || zipNodes.length == 0) {
            throw new IllegalArgumentException("The given zip nodes cannot be null or empty");
        }

        return new Cursor<>(zipNode, shallowCopyInsertRight(zipNodes));
    }

    public Cursor<T> remove() {

        if (isRoot()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the root node");
        }

        return new Cursor<>(new ZipNode<>((T) range.getParentZipNode().unwrap(),
                shallowCopyRemove()), range.getParentRange());
    }

    public Cursor<T> removeLeft() {

        if (isFirst()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the left-most node");
        }

        return new Cursor<>(zipNode, shallowCopyRemoveLeft());
    }

    public Cursor<T> removeRight() {

        if (isLast()) {
            throw new UnsupportedOperationException(
                    "This operation is not supported for the right-most node");
        }

        return new Cursor<>(zipNode, shallowCopyRemoveRight());
    }

    public Cursor<T> replace(Zippable node) {
        
        if(node == null) {
            throw new IllegalArgumentException("The given zip node cannot be null");
        }
        
        return new Cursor<>(toZipNode(node), shallowCopyReplace(range));
    }

    public Cursor<T> replaceOriginal(T node) {
        
        if(node == null) {
            throw new IllegalArgumentException("The given zip node cannot be null");
        }

        if (node instanceof ZipNode<?>) {
            throw new IllegalArgumentException("Cannot replace an original node with a zip node");
        }

        return new Cursor<>(this.zipNode.replaceNode(node), shallowCopyReplace(range));
    }

    // helper method to get a new zip node
    private ZipNode<T> toZipNode(final Zippable node) {
        
        if (node instanceof ZipNode<?>) {
            return (ZipNode<T>) node;
        } else {
            return new ZipNode<>((T) node);
        }
    }

    // helper method for the up() navigation
    private Zippable[] shallowCopyUp() {

        Zippable[] zippable = new Zippable[range.leftSiblings().length + range.rightSiblings().length + 1];
        System.arraycopy(range.leftSiblings(), 0, zippable, 0, range.leftSiblings().length);
        zippable[range.leftSiblings().length] = zipNode;
        System.arraycopy(range.rightSiblings(), 0, zippable,
                range.leftSiblings().length + 1, range.rightSiblings().length);

        return zippable;
    }

    // helper method for the down() navigation
    private ZipperRange shallowCopyDown(int index) {

        Zippable[] leftSide = new Zippable[index];
        System.arraycopy(zipNode.children(), 0, leftSide, 0, leftSide.length);
        Zippable[] rightSide = new Zippable[zipNode.children().length - index - 1];
        System.arraycopy(zipNode.children(), index + 1, rightSide, 0, rightSide.length);

        return new ZipperRange(zipNode, range, leftSide, rightSide);
    }

    // helper method for the right() navigation
    private ZipperRange shallowCopyRight() {

        Zippable[] leftSide = new Zippable[range.leftSiblings().length + 1];
        System.arraycopy(range.leftSiblings(), 0, leftSide, 0, range.leftSiblings().length);
        leftSide[leftSide.length - 1] = zipNode;

        Zippable[] rightSide = new Zippable[range.rightSiblings().length - 1];
        System.arraycopy(range.rightSiblings(), 1, rightSide, 0, range.rightSiblings().length - 1);

        return new ZipperRange(range.getParentZipNode(), range.getParentRange(), leftSide, rightSide);
    }

    // helper method for the left() navigation
    private ZipperRange shallowCopyLeft(int leftlen) {

        Zippable[] leftSide = new Zippable[leftlen];
        System.arraycopy(range.leftSiblings(), 0, leftSide, 0, range.leftSiblings().length - 1);

        Zippable[] rightSide = new Zippable[range.rightSiblings().length + 1];
        System.arraycopy(range.rightSiblings(), 0, rightSide, 1, range.rightSiblings().length);
        rightSide[0] = zipNode;

        return new ZipperRange(range.getParentZipNode(), range.getParentRange(), leftSide, rightSide);
    }

    // helper method for the add() operation
    private Zippable[] shallowCopyAdd(T... zipNodes) {

        Zippable[] zippable = new Zippable[zipNodes.length + zipNode.children().length];
        System.arraycopy(zipNode.children(), 0, zippable, 0, zipNode.children().length);
        System.arraycopy(zipNodes, 0, zippable, zipNode.children().length, zipNodes.length);

        return zippable;
    }   

    // helper method for insertLeft() operation
    private ZipperRange shallowCopyInsertLeft(T... zipNodes) {

        Zippable[] leftSide = new Zippable[range.leftSiblings().length + zipNodes.length];
        System.arraycopy(range.leftSiblings(), 0, leftSide, 0, range.leftSiblings().length);
        System.arraycopy(zipNodes, 0, leftSide, range.leftSiblings().length, zipNodes.length);

        Zippable[] rightSide = new Zippable[range.rightSiblings().length];
        System.arraycopy(range.rightSiblings(), 0, rightSide, 0, range.rightSiblings().length);

        return new ZipperRange(range.getParentZipNode(), range.getParentRange(), leftSide, rightSide);
    }

    // helper method for insertRight() operation
    private ZipperRange shallowCopyInsertRight(T... zipNodes) {

        Zippable[] leftSide = new Zippable[range.leftSiblings().length];
        System.arraycopy(range.leftSiblings(), 0, leftSide, 0, range.leftSiblings().length);

        Zippable[] rightSide = new Zippable[range.rightSiblings().length + zipNodes.length];
        System.arraycopy(zipNodes, 0, rightSide, 0, zipNodes.length);
        System.arraycopy(range.rightSiblings(), 0, rightSide, zipNodes.length, range.rightSiblings().length);

        return new ZipperRange(range.getParentZipNode(), range.getParentRange(), leftSide, rightSide);
    }

    // helper method for the remove() operation
    private Zippable[] shallowCopyRemove() {

        Zippable[] zippable = new Zippable[range.leftSiblings().length
                + range.rightSiblings().length];
        System.arraycopy(range.leftSiblings(), 0, zippable, 0, range.leftSiblings().length);
        System.arraycopy(range.rightSiblings(), 0, zippable,
                range.leftSiblings().length, range.rightSiblings().length);

        return zippable;
    }

    // helper method for removeLeft() operation
    private ZipperRange shallowCopyRemoveLeft() {

        Zippable[] leftSide = new Zippable[range.leftSiblings().length - 1];
        System.arraycopy(range.leftSiblings(), 0, leftSide, 0, range.leftSiblings().length - 1);

        Zippable[] rightSide = new Zippable[range.rightSiblings().length];
        System.arraycopy(range.rightSiblings(), 0, rightSide, 0, range.rightSiblings().length);

        return new ZipperRange(range.getParentZipNode(), range.getParentRange(), leftSide, rightSide);
    }

    // helper method for removeRight() operation
    private ZipperRange shallowCopyRemoveRight() {

        Zippable[] leftSide = new Zippable[range.leftSiblings().length];
        System.arraycopy(range.leftSiblings(), 0, leftSide, 0, range.leftSiblings().length);

        Zippable[] rightSide = new Zippable[range.rightSiblings().length - 1];
        System.arraycopy(range.rightSiblings(), 1, rightSide, 0, range.rightSiblings().length - 1);

        return new ZipperRange(range.getParentZipNode(), range.getParentRange(), leftSide, rightSide);
    }

    // helper method for replace() and replaceOriginal() operations
    private ZipperRange shallowCopyReplace(ZipperRange zipperRange) {

        Zippable[] leftSide = zipperRange.leftSiblings().clone();
        Zippable[] rightSide = zipperRange.rightSiblings().clone();

        return new ZipperRange(zipperRange.getParentZipNode(),
                zipperRange.getParentRange(), leftSide, rightSide);
    }
}