package modern.challenge;

public class Main {

    public static void main(String[] args) {

        String dummyText = "aaaaaaaaaaa";  
        
        Huffman huffman = new Huffman();
        huffman.tree(dummyText);
        
        System.out.println("\nEncoded: " + huffman.encode());
        System.out.println("Decoded: " + huffman.decode());
        
        System.out.println();        
        String text = "datastructures";
        huffman.tree(text);
                
        System.out.println("\nEncoded:" + huffman.encode());
        System.out.println("Decoded: " + huffman.decode());
    }
}