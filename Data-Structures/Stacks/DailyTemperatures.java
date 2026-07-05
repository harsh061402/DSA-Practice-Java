/**
 * Problem: Daily Temperatures
 * Link: https://leetcode.com/problems/daily-temperatures/
 * * Time Complexity: O(n) - Each element is pushed and popped from the stack at most once.
 * Space Complexity: O(n) - Auxiliary stack space to store indices.
 */

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices of elements

        for (int i = 0; i < n; i++) {
            // While stack is not empty and current temperature is warmer than the index on top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // Calculate days to wait
            }
            stack.push(i); // Push current index onto the stack
        }

        return result;
    }
}