/**
 * Problem: Largest Rectangle in Histogram
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * * Time Complexity: O(n) - Each bar index is pushed and popped from the stack exactly once.
 * Space Complexity: O(n) - Monotonic stack auxiliary memory.
 */

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>(); // Monotonically increasing stack of indices
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Treat the end of the array as a virtual bar of height 0 to clear out the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // While the current bar is shorter than the bar at the top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // Calculate the width of the rectangle extending to the left boundary
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}