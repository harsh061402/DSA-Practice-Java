/**
 * Problem: 3Sum
 * Link: https://leetcode.com/problems/3sum/
 * * Time Complexity: O(n^2) - Sorting takes O(n log n), and the nested loops take O(n^2).
 * Space Complexity: O(1) or O(log n) - Depends on the implementation of the sorting algorithm.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array to utilize two-pointer logic
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the left and right elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum is too small, move left pointer to increase it
                } else {
                    right--; // Sum is too large, move right pointer to decrease it
                }
            }
        }
        return result;
    }
}