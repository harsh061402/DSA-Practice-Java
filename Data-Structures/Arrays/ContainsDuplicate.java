/**
 * Problem: Contains Duplicate
 * Link: https://leetcode.com/problems/contains-duplicate/
 * * Time Complexity: O(n) - We iterate through the array once and lookup/insert into a HashSet is O(1).
 * Space Complexity: O(n) - In the worst case, all unique elements are stored in the set.
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Create a set to track elements we have already seen
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // If the element is already in the set, we found a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add it to the set
            seen.add(num);
        }

        return false;
    }
}