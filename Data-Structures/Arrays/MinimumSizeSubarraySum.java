/**
 * Problem: Minimum Size Subarray Sum
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 * * Time Complexity: O(n) - Each element is visited at most twice (once by right, once by left pointer).
 * Space Complexity: O(1) - Constant auxiliary space used for tracking windows and minimal length.
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink the window from the left as long as the condition is satisfied
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength wasn't updated, it means no valid subarray was found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}