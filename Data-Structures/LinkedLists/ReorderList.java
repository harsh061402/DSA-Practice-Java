/**
 * Problem: Reorder List
 * Link: https://leetcode.com/problems/reorder-list/
 * * Time Complexity: O(n) - Linear time for finding middle, reversing, and merging.
 * Space Complexity: O(1) - In-place manipulation without structural reallocation.
 */

public class ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list (starting after slow)
        ListNode prev = null;
        ListNode current = slow.next;
        slow.next = null; // Split the list into two individual halves

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 3: Merge the two sorted halves alternately
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // Head of the reversed second half

        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}