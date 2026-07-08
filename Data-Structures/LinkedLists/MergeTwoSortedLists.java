/**
 * Problem: Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 * * Time Complexity: O(n + m) - Where n and m are the lengths of the two input lists.
 * Space Complexity: O(1) - The nodes are spliced in-place without creating new structural memory.
 */

public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the structural starting point
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append whichever list has remaining elements left over
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next; // The merged list starts immediately after the dummy node
    }
}