/*
 * ============================================================================
 * File Name    : CodingTest.java
 * Author       : Viral Prajapati
 * Description  :
 * This program demonstrates how to find the middle node of a Singly Linked List
 * using the Two Pointer Technique (Slow Pointer and Fast Pointer).
 *
 * Logic:
 * - slow pointer moves 1 step at a time
 * - fast pointer moves 2 steps at a time
 *
 * When fast reaches the end of the linked list,
 * slow will automatically be positioned at the middle node.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 * ============================================================================
 */

public class CodingTest {

    /*
     * ============================================================
     * Node Class
     * ============================================================
     * This class represents a single node in the Linked List.
     *
     * Each node contains:
     * 1. data  -> stores integer value
     * 2. next  -> stores reference/address of next node
     * ============================================================
     */
    static class Node {

        // Variable to store node data
        int data;

        // Variable to store reference of next node
        Node next;

        /*
         * Constructor of Node class
         *
         * Whenever a new node is created,
         * this constructor initializes:
         * - data value
         * - next pointer as null
         */
        Node(int d) {

            // Assign incoming value to node data
            data = d;

            // Initially next node is null
            next = null;
        }
    }

    /*
     * ============================================================
     * Method Name : getMiddle
     * ============================================================
     * Purpose:
     * Finds the middle node of the linked list.
     *
     * Approach:
     * Uses Slow and Fast Pointer Algorithm.
     *
     * slow -> moves 1 step
     * fast -> moves 2 steps
     *
     * When fast reaches the end,
     * slow reaches the middle.
     *
     * Example:
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * Output:
     * 3
     * ============================================================
     */
    public static int getMiddle(Node head) {

        /*
         * Initially both slow and fast pointers
         * are pointing to the head node.
         */
        Node slow = head;
        Node fast = head;

        /*
         * ========================================================
         * Traversal Loop
         * ========================================================
         *
         * Condition Explanation:
         *
         * fast != null
         * Checks whether fast pointer exists
         *
         * fast.next != null
         * Checks whether next node exists
         *
         * Why both conditions?
         * Because fast moves 2 steps at a time.
         * We must ensure:
         * - current node exists
         * - next node exists
         *
         * Otherwise NullPointerException may occur.
         * ========================================================
         */
        while (fast != null && fast.next != null) {

            /*
             * ====================================================
             * VISUALIZATION - ITERATION 1
             * ====================================================
             *
             * Linked List:
             *
             * 1 -> 2 -> 3 -> 4 -> 5 -> null
             *
             * Initial Position:
             *
             * slow = 1
             * fast = 1
             *
             * After Movement:
             *
             * slow moves 1 step:
             * 1 -> 2
             *
             * fast moves 2 steps:
             * 1 -> 3
             * ====================================================
             */

            // Move slow pointer by 1 node
            slow = slow.next;

            // Move fast pointer by 2 nodes
            fast = fast.next.next;

            /*
             * ====================================================
             * VISUALIZATION - ITERATION 2
             * ====================================================
             *
             * Current Position:
             *
             * slow = 2
             * fast = 3
             *
             * After Movement:
             *
             * slow:
             * 2 -> 3
             *
             * fast:
             * 3 -> 5
             * ====================================================
             */

            /*
             * ====================================================
             * VISUALIZATION - ITERATION 3
             * ====================================================
             *
             * Current Position:
             *
             * slow = 3
             * fast = 5
             *
             * Now:
             *
             * fast.next = null
             *
             * Loop condition fails.
             *
             * Therefore:
             * slow is pointing to the middle node.
             * ====================================================
             */
        }

        /*
         * At this point:
         *
         * slow = middle node
         *
         * Returning middle node data.
         */
        return slow.data;
    }

    /*
     * ============================================================
     * Main Method
     * ============================================================
     * Program execution starts from here.
     *
     * We manually create the linked list:
     *
     * 1 -> 2 -> 3 -> 4 -> 5
     * ============================================================
     */
    public static void main(String[] args) {

        /*
         * Create first node
         *
         * head -> 1
         */
        Node head = new Node(1);

        /*
         * Create second node and connect it
         *
         * 1 -> 2
         */
        head.next = new Node(2);

        /*
         * Create third node and connect it
         *
         * 1 -> 2 -> 3
         */
        head.next.next = new Node(3);

        /*
         * Create fourth node and connect it
         *
         * 1 -> 2 -> 3 -> 4
         */
        head.next.next.next = new Node(4);

        /*
         * Create fifth node and connect it
         *
         * 1 -> 2 -> 3 -> 4 -> 5
         */
        head.next.next.next.next = new Node(5);

        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next.next = new Node(7);

        head.next.next.next.next.next.next.next = new Node(8);

        head.next.next.next.next.next.next.next.next = new Node(9);



        /*
         * Calling getMiddle() method
         * to find middle node.
         */
        System.out.println("Middle Node: " + getMiddle(head));

        /*
         * Final Output:
         *
         * Middle Node: 3
         */
    }
}