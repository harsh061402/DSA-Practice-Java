/**
 * Problem: Search in Rotated Sorted Array
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Time Complexity: O(log n) - Modified binary search halving the search space each step.
 * Space Complexity: O(1) - Constant auxiliary space using pointers.
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target lies within the left sorted portion
                } else {
                    left = mid + 1;  // Target lies in the right portion
                }
            }
            // Otherwise, the right half must be sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target lies within the right sorted portion
                } else {
                    right = mid - 1; // Target lies in the left portion
                }
            }
        }

        return -1;
    }
}