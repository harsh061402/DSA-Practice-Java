/**
 * Problem: Longest Increasing Subsequence
 * Link: https://leetcode.com/problems/longest-increasing-subsequence/
 * Time Complexity: O(n^2) - Nested loops to check all previous indices for each element.
 * Space Complexity: O(n) - 1D DP array to store subsequence lengths.
 */

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        // Every element is an increasing subsequence of length 1 by itself
        Arrays.fill(dp, 1);

        int maxLIS = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }
}