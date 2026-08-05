/**
 * Problem: Coin Change
 * Link: https://leetcode.com/problems/coin-change/
 * Time Complexity: O(amount * n) - Where n is the number of coin denominations.
 * Space Complexity: O(amount) - 1D array used to store optimal subproblem solutions.
 */

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Fill array with amount + 1 as a representation of infinity
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] wasn't updated, amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}