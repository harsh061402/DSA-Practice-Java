/**
 * Problem: Group Anagrams
 * Link: https://leetcode.com/problems/group-anagrams/
 * * Time Complexity: O(n * m log m) - Where n is the number of strings and m is the max string length (due to sorting keys).
 * Space Complexity: O(n * m) - Storing the strings and their groupings in the HashMap.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to character array and sort it to create a uniform key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);

            // Initialize the list if the key doesn't exist yet
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            // Add the original string to its corresponding anagram group
            map.get(sortedKey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}