/**
 * Problem: Partition Equal Subset Sum
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 * Time Complexity: O(n * target) - Where target is half the total array sum.
 * Space Complexity: O(target) - 1D boolean state array for subset targets.
 */

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Odd total sum cannot be partitioned into two equal integer subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: target 0 is always reachable with an empty set

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}