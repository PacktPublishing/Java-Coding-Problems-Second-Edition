package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SkipList {

    private static final int MAX_NUMBER_OF_LAYERS = 10;

    private final Node head;
    private final Random rnd = new Random();

    private int size;
    private int topLayer;

    private final class Node {

        private final Integer data;
        private final int layer;

        public Node[] next;

        public Node(Integer data, int layer) {

            this.data = data;
            this.layer = layer;
            this.next = new Node[layer + 1];
        }

        public Integer getData() {
            return this.data;
        }

        @Override
        public String toString() {
            return "{ layer " + layer + " :: data " + data + " }";
        }
    }

    public SkipList() {

        this.size = 0;
        this.topLayer = 1;

        this.head = new Node(null, MAX_NUMBER_OF_LAYERS);
    }

    public void insert(Integer data) {

        int layer = incrementLayerNo();

        Node newNode = new Node(data, layer);

        Node cursorNode = head;

        for (int i = topLayer - 1; i >= 0; i--) {
            while (cursorNode.next[i] != null) {
                if (cursorNode.next[i].getData() > data) {
                    break;
                }

                cursorNode = cursorNode.next[i];
            }

            if (i <= layer) {
                newNode.next[i] = cursorNode.next[i];
                cursorNode.next[i] = newNode;
            }
        }

        size++;
    }
    
    public boolean delete(Integer data) {

        Node cursorNode = head;
        boolean deleted = false;
        
        for (int i = topLayer - 1; i >= 0; i--) {
            while (cursorNode.next[i] != null) {

                if (cursorNode.next[i].getData() > data) {
                    break;
                }

                if (cursorNode.next[i].getData().equals(data)) {                    
                    cursorNode.next[i] = cursorNode.next[i].next[i];
                    deleted = true;
                    size--;

                    break;
                }

                cursorNode = cursorNode.next[i];
            }
        }

        return deleted;
    }
    
    public boolean contains(Integer data) {

        Node cursorNode = head;
        
        for (int i = topLayer - 1; i >= 0; i--) {
            while (cursorNode.next[i] != null) {
                if (cursorNode.next[i].getData() > data) {
                    break;
                }

                if (cursorNode.next[i].getData().equals(data)) {
                    return true;
                }

                cursorNode = cursorNode.next[i];
            }
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public void printList() {

        Node cursorNode = head;
        int layer = MAX_NUMBER_OF_LAYERS - 1;
        
        while (cursorNode.next[layer] == null && layer > 0) {
            layer--;            
        }

        cursorNode = head;
        List<Node> nodes = new ArrayList<>();
        while (cursorNode != null) {
            nodes.add(cursorNode);
            cursorNode = cursorNode.next[0];
        }

        for (int i = 0; i <= layer; i++) {

            cursorNode = head;
            cursorNode = cursorNode.next[i];
            System.out.print("Layer " + i + " | start |");

            int layerNo = 1;
            while (cursorNode != null) {

                if (i > 0) {
                    while (!Objects.equals(nodes.get(layerNo).getData(), cursorNode.getData())) {
                        layerNo++;
                        System.out.print("--------------------------");
                    }

                    layerNo++;
                }

                System.out.print("---> " + cursorNode);
                cursorNode = cursorNode.next[i];
            }

            System.out.println();
        }
    }

    private int incrementLayerNo() {

        int layer = 0;
        boolean headFlag = true;

        for (int i = 0; i < MAX_NUMBER_OF_LAYERS; i++) {
            headFlag &= rnd.nextBoolean();

            if (headFlag) {
                layer++;
                if (layer == this.topLayer) {
                    topLayer++;
                    break;
                }
            } else {
                break;
            }
        }

        return layer;
    }
}