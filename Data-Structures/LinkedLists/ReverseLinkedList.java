/**
 * Problem: Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/
 * * Time Complexity: O(n) - We visit every node in the list exactly once.
 * Space Complexity: O(1) - We only change pointer references in-place without extra memory.
 */

// Definition for singly-linked list node provided by LeetCode
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Temporarily store the next node
            current.next = prev;             // Reverse the current node's pointer
            prev = current;                  // Move prev forward
            current = nextNode;              // Move current forward
        }

        return prev; // prev will be pointing to the new head of the reversed list
    }
}