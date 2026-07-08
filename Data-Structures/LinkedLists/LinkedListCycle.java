/**
 * Problem: Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/
 * * Time Complexity: O(n) - Linear scan where the fast pointer catches up to the slow pointer.
 * Space Complexity: O(1) - Constant auxiliary memory utilizing only two pointer variables.
 */

public class LinkedListCycle {
    // Definition for singly-linked list node is assumed to be within scope
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer by 2 steps and slow pointer by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false; // Fast pointer reached the end, so no cycle exists
    }
}