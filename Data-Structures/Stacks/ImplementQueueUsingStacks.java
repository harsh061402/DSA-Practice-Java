/**
 * Problem: Implement Queue using Stacks
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 * * Time Complexity: Push: O(1), Pop/Peek: O(1) Amortized - Elements are moved between stacks at most once.
 * Space Complexity: O(n) - Auxiliary storage for maintaining the elements across two stacks.
 */

import java.util.Stack;

public class ImplementQueueUsingStacks {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek(); // Ensure output stack has the current elements in FIFO order
        return output.pop();
    }

    public int peek() {
        // If output stack is empty, shift all elements from input to output
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}