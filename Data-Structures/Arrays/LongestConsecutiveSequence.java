/**
 * Problem: Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * * Time Complexity: O(n) - We traverse the array to add elements to the set, and then visit each element at most twice.
 * Space Complexity: O(n) - Auxiliary space used to store array elements in a HashSet.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Insert all numbers into a HashSet for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            // Check if 'num' is the start of a sequence
            // If the set contains (num - 1), then 'num' is NOT the start
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand the sequence forward
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the maximum sequence length found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}