/**
 * Problem: Word Search II
 * Link: https://leetcode.com/problems/word-search-ii/
 * Time Complexity: O(M * N * 4^L) - Where M, N are grid dimensions and L is max word length.
 * Space Complexity: O(K * L) - Trie storage for K words of maximum length L.
 */

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store complete word at leaf nodes to avoid rebuilding strings
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Found a matching word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Prevent duplicate entries in output
        }

        board[r][c] = '#'; // Mark cell as visited

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                dfs(board, nr, nc, node, result);
            }
        }

        board[r][c] = ch; // Backtrack state
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }
}