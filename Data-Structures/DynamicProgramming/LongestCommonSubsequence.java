/**
 * Problem: Longest Common Subsequence
 * Link: https://leetcode.com/problems/longest-common-subsequence/
 * Time Complexity: O(m * n) - Where m and n are lengths of text1 and text2.
 * Space Complexity: O(m * n) - 2D grid used to store subproblem state results.
 */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Matching characters: add 1 to the diagonal subproblem result
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Non-matching: take the max from top or left adjacent states
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}