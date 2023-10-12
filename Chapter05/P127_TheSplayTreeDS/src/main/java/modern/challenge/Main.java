package modern.challenge;

public class Main {

    public static void main(String[] args) {
        
        SplayTree st = new SplayTree();
        
        st.insert(12);
        st.insert(5);
        st.insert(123);
        st.insert(1);
        st.insert(122);
        st.insert(10);
        st.insert(90);
        st.insert(92);
        
        st.print(SplayTree.TraversalOrder.LEVEL);
        
        System.out.println("\nFound 5: " + st.search(5));
        
        st.print(SplayTree.TraversalOrder.LEVEL);
        
        System.out.println("\nFound 90: " + st.search(90));
        
        st.print(SplayTree.TraversalOrder.LEVEL);
        
        System.out.println("\nDeleting 10 ...");        
        st.delete(10);
        
        st.print(SplayTree.TraversalOrder.LEVEL);
        
    }
}