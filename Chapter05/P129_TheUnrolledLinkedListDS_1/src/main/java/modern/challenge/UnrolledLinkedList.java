package modern.challenge;

import java.util.Arrays;

public class UnrolledLinkedList {

    private Node head;
    private int size;

    private final class Node {

        private Node next;
        private int[] arr;

        private Node(Node next, int[] arr) {
            this.next = next;
            this.arr = arr;
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }

    public void insert(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        if (this.head == null) {
            this.head = new Node(null, arr);
        } else {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(null, arr);
        }

        this.size += arr.length;
    }

    public int get(int index) {

        if (index < 0 || index > this.size) {
            return Integer.MIN_VALUE;
        }

        Node temp = this.head;
        while (index >= temp.arr.length) {
            index -= temp.arr.length;
            temp = temp.next;
        }

        return temp.arr[index];
    }

    public void delete(int index) {

        if (index < 0 || index > this.size) {
            return;
        }

        if (index < this.head.arr.length) {
            int[] arr = this.head.arr;
            this.head.arr = buildNewArr(arr, index);
        } else {

            Node temp = this.head;
            index -= temp.arr.length;
            while (index >= temp.next.arr.length) {
                index -= temp.next.arr.length;
                temp = temp.next;
            }

            if (temp.next.arr.length == 1) {

                temp.next = temp.next.next;
            } else {
                int[] arr = temp.next.arr;
                temp.next.arr = buildNewArr(arr, index);;
            }
        }

        this.size--;
    }

    private int[] buildNewArr(int[] arr, int index) {

        int[] newArr = new int[arr.length - 1];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            newArr[j++] = arr[i];
        }

        return newArr;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        if (this.head == null) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder("{");
        Node tmp = this.head;
        while (tmp.next != null) {
            sb.append(tmp.toString()).append(", ");
            tmp = tmp.next;
        }

        return sb.append(tmp.toString()).append("}").toString();
    }
}