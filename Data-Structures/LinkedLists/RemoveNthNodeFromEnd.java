/**
 * Problem: Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * * Time Complexity: O(n) - Single linear pass traversing the list once.
 * Space Complexity: O(1) - Constant auxiliary pointer space.
 */

public class RemoveNthNodeFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node handles edge cases like removing the head node seamlessly
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer so that there is a gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the target node to delete it from the references
        slow.next = slow.next.next;

        return dummy.next;
    }
}
