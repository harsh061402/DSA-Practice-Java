/**
 * Problem: Two Sum
 * Link: https://leetcode.com/problems/two-sum/
 * * Time Complexity: O(n) - Single pass through the array using a Hash Map.
 * Space Complexity: O(n) - In the worst case, we store all elements in the map.
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Map to store the value and its corresponding index
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists, we found the pair
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            // Otherwise, store the current number and index
            numMap.put(nums[i], i);
        }

        // Return empty array if no solution is found
        return new int[] {};
    }
}
