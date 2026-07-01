/**
 * Problem: Min Stack
 * Link: https://leetcode.com/problems/min-stack/
 * * Time Complexity: O(1) - All operations run in constant time.
 * Space Complexity: O(n) - In the worst case, the minStack stores an element for every push.
 */

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // If minStack is empty or val is smaller/equal to current min, push to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // If the element being removed is the current minimum, pop it from minStack too
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}