/**
 * Problem: Kth Largest Element in an Array
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Time Complexity: O(n log k) - Maintaining a min-heap of size k across n elements.
 * Space Complexity: O(k) - Storage allocated for the min-heap.
 */

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Min-Heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            // Maintain heap size to at most k
            if (minHeap.size() > k) {
                minHeap.poll(); // Evict the smallest element
            }
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}