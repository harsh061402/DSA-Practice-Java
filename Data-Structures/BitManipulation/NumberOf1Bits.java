/**
 * Problem: Number of 1 Bits
 * Link: https://leetcode.com/problems/number-of-1-bits/
 * Time Complexity: O(k) - Where k is the number of set bits (at most 32 iterations).
 * Space Complexity: O(1) - Constant auxiliary memory.
 */

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= (n - 1); // Clears the lowest set bit
            count++;
        }

        return count;
    }
}