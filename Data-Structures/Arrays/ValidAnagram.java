/**
 * Problem: Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 * * Time Complexity: O(n) - Single pass to count characters where n is the length of the string.
 * Space Complexity: O(1) - Constant auxiliary space using a fixed-size array of 26 integers.
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, t is an anagram of s
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}