/**
 * Problem: Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/
 * * Time Complexity: O(n) - We traverse the string exactly once.
 * Space Complexity: O(n) - In the worst case, the stack stores all opening brackets.
 */

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check for matching opening bracket
            else {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) return false;

                char openBracket = stack.pop();
                if ((ch == ')' && openBracket != '(') ||
                        (ch == '}' && openBracket != '{') ||
                        (ch == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}