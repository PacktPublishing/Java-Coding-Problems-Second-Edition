package modern.challenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Huffman {

    private Node root;
    private String str;
    private StringBuilder encodedStr;
    private StringBuilder decodedStr;

    private final class Node {
        
        private Node left;
        private Node right;

        private final Character character;
        private final Integer frequency;
        
        private Node(Character character, Integer frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        private Node(Character character, Integer frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

    public void tree(String str) {

        if (str == null || str.isBlank()) {
            return;
        }

        this.str = str;
        this.root = null;
        this.encodedStr = null;
        this.decodedStr = null;

        Map<Character, Integer> frequency = new HashMap<>();

        for (char character : str.toCharArray()) {
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(ch -> ch.frequency));

        for (Entry<Character, Integer> entry : frequency.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }
        
        while (queue.size() != 1) {

            Node left = queue.poll();
            Node right = queue.poll();

            int sum = left.frequency + right.frequency;

            queue.add(new Node(null, sum, left, right));        }

        this.root = queue.peek();
    }

    public String encode() {

        if (this.root == null) {
            throw new NoSuchElementException("There is no data available");
        }

        Map<Character, String> codes = new HashMap<>();
        encode(this.root, "", codes);

        this.encodedStr = new StringBuilder();
        for (char character : this.str.toCharArray()) {
            this.encodedStr.append(codes.get(character));
            System.out.print(codes.get(character) + "(" + character + ") ");
        }        

        return this.encodedStr.toString();
    }

    private void encode(Node root, String str, Map<Character, String> codes) {

        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            codes.put(root.character, str.length() > 0 ? str : "1");
        }

        encode(root.left, str + '0', codes);
        encode(root.right, str + '1', codes);
    }

    public String decode() {

        if (this.root == null || this.encodedStr == null || this.encodedStr.isEmpty()) {
            throw new NoSuchElementException("There is no data available");
        }

        this.decodedStr = new StringBuilder();

        if (isLeaf(this.root)) {           
            int copyFrequency = this.root.frequency;
            while (copyFrequency-- > 0) {
                decodedStr.append(root.character);
            }
        } else {
            int index = -1;
            while (index < this.encodedStr.length() - 1) {
                index = decode(this.root, index);
            }
        }

        return decodedStr.toString();
    }

    private int decode(Node root, int index) {

        if (root == null) {
            return index;
        }

        if (isLeaf(root)) {
            decodedStr.append(root.character);
            return index;
        }

        index++;
        root = (this.encodedStr.charAt(index) == '0') ? root.left : root.right;

        index = decode(root, index);

        return index;
    }

    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}