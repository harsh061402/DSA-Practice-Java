/**
 * Problem: Climbing Stairs
 * Link: https://leetcode.com/problems/climbing-stairs/
 * Time Complexity: O(n) - Single loop iterating from 3 to n.
 * Space Complexity: O(1) - Constant memory optimized using two variables instead of a DP array.
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1; // Base case for n = 1
        int prev1 = 2; // Base case for n = 2
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}