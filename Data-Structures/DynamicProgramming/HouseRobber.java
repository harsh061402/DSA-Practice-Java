/**
 * Problem: House Robber
 * Link: https://leetcode.com/problems/house-robber/
 * Time Complexity: O(n) - Single pass through the house values array.
 * Space Complexity: O(1) - Memory optimized using two tracking variables instead of an array.
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // Represents max money robbed up to i - 2
        int prev1 = 0; // Represents max money robbed up to i - 1

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}