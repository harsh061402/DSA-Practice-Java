/**
 * Problem: Single Number
 * Link: https://leetcode.com/problems/single-number/
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Bitwise XOR manipulation using constant auxiliary space.
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR all elements; duplicates cancel each other out
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}