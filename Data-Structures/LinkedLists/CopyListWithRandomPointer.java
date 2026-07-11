/**
 * Problem: Copy List with Random Pointer
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 * * Time Complexity: O(n) - Three linear passes over the list structure.
 * Space Complexity: O(1) - Modifying pointers in-place without auxiliary maps.
 */

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave cloned nodes within the original list
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original list and the cloned list
        curr = head;
        Node cloneHead = head.next;
        Node currClone = cloneHead;

        while (curr != null) {
            curr.next = curr.next.next;
            currClone.next = (currClone.next != null) ? currClone.next.next : null;

            curr = curr.next;
            currClone = currClone.next;
        }

        return cloneHead;
    }
}