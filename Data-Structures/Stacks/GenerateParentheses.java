/**
 * Problem: Generate Parentheses
 * Link: https://leetcode.com/problems/generate-parentheses/
 * * Time Complexity: O(4^n / sqrt(n)) - Bound by the n-th Catalan number.
 * Space Complexity: O(n) - Due to the maximum recursive call stack depth and backtracking string state.
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base Case: If the current string reaches the max length valid size
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Rule 1: We can always add an opening parenthesis if we haven't reached the max count
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack step
        }

        // Rule 2: We can only add a closing parenthesis if it matches an open one
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack step
        }
    }
}