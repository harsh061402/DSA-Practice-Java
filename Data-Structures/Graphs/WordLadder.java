/**
 * Problem: Word Ladder
 * Link: https://leetcode.com/problems/word-ladder/
 * Time Complexity: O(N * M^2) - Where N is number of words in wordList and M is word length.
 * Space Complexity: O(N * M) - Queue and hash set memory storage.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return level;

                char[] wordChars = currentWord.toCharArray();
                // Try changing each character from 'a' to 'z'
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordChars[j] == c) continue;

                        wordChars[j] = c;
                        String newWord = String.valueOf(wordChars);

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark visited by removing from set
                        }
                    }
                    wordChars[j] = originalChar; // Reset back to original character
                }
            }
            level++;
        }

        return 0;
    }
}