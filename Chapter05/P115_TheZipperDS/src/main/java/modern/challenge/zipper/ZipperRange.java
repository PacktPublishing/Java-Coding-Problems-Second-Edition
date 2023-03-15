package modern.challenge.zipper;

final class ZipperRange {
    
    private final ZipperRange parentRange;
    private final ZipNode<?> parentZipNode;
    private final Zippable[] leftSiblings;
    private final Zippable[] rightSiblings;

    protected ZipperRange(final ZipNode<?> parentZipNode, final ZipperRange parentRange,
            final Zippable[] leftSiblings, final Zippable[] rightSiblings) {

        this.parentZipNode = parentZipNode;
        this.parentRange = parentRange;
        this.leftSiblings = (leftSiblings == null) ? new Zippable[0] : leftSiblings;
        this.rightSiblings = (rightSiblings == null) ? new Zippable[0] : rightSiblings;
    }   

    protected boolean isFirst() {
        return leftSiblings.length == 0; // if it is the first node then it has no left siblings
    }

    protected boolean isLast() {
        return rightSiblings.length == 0; // if it is the last node then it has no right siblings
    }
    
    protected boolean isRoot() {
        return parentZipNode == null;
    }    

    protected Zippable[] leftSiblings() {
        return leftSiblings;
    }

    protected Zippable[] rightSiblings() {
        return rightSiblings;
    }

    protected ZipperRange getParentRange() {
        return parentRange;
    }

    protected ZipNode<?> getParentZipNode() {
        return parentZipNode;
    }    
}