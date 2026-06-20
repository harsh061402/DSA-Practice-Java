/**
 * Problem: Two Sum II - Input Array Is Sorted
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * * Time Complexity: O(n) - Linear scan from both ends towards the center.
 * Space Complexity: O(1) - Constant space utilizing two pointer variables.
 */

public class TwoSumTwoSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // The problem requires 1-indexed answers
                return new int[] { left + 1, right + 1 };
            }
            // If the sum is too small, move the left pointer to increase the sum
            else if (currentSum < target) {
                left++;
            }
            // If the sum is too large, move the right pointer to decrease the sum
            else {
                right--;
            }
        }

        return new int[] {};
    }
}