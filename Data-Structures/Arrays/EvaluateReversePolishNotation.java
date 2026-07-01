/**
 * Problem: Evaluate Reverse Polish Notation
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * * Time Complexity: O(n) - Single pass through the tokens array.
 * Space Complexity: O(n) - Auxiliary stack space to store operands.
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // The first popped element is the right operand
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                // Parse the string token into an integer and push it
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}