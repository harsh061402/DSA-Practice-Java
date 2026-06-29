/**
 * Problem: Subarray Sum Equals K
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * * Time Complexity: O(n) - Single linear pass to compute cumulative sum.
 * Space Complexity: O(n) - Storing prefix sum frequencies in a HashMap.
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        // HashMap to store (prefixSum, frequency)
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Base case: a prefix sum of 0 is seen once initially
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in the map, add its frequency to the count
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Record the current prefix sum into the map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}