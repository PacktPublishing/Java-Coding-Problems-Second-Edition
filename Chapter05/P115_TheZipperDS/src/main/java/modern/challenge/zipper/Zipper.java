package modern.challenge.zipper;

import java.util.Collection;

@SuppressWarnings("unchecked")
public final class Zipper {

    public static <T extends Zippable> Cursor<T> createZipper(final T node) {
        return new Cursor<>(new ZipNode<>(node),
                new ZipperRange(null, null, null, null)); // root range
    }

    public static <T extends Zippable> T unwrapZipper(final Cursor<T> tree) {
        return Zipper.<T>unwrapZipper(tree.root().zipNode());
    }

    private static <T extends Zippable> T unwrapZipper(final Zippable node) {

        if (node instanceof ZipNode<?>) {

            ZipNode<T> zipNode = (ZipNode<T>) node;
            T original = zipNode.unwrap();

            if (!zipNode.isLeaf()) {

                Collection<T> children = (Collection<T>) original.getChildren();
                original.getChildren().clear();

                for (Zippable zipped : zipNode.children()) {
                    children.add((T) unwrapZipper(zipped));
                }
            }
            
            return original;
        } else {
            
            return (T) node;
        }
    }
}
