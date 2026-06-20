package linkedlist.basic.intermediate.advance;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointers {

    static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node clone(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.data));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node clonedNode = map.get(current);
            clonedNode.next = map.get(current.next);
            clonedNode.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        // Problem 13: Clone linked list with random pointers.
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node2;
        node2.next = node3;
        head.random = node3;
        node2.random = head;

        Node clonedHead = clone(head);
        System.out.println("Original head data: " + head.data);
        System.out.println("Cloned head data: " + clonedHead.data);
        System.out.println("Original head random data: " + head.random.data);
        System.out.println("Cloned head random data: " + clonedHead.random.data);
    }
}
