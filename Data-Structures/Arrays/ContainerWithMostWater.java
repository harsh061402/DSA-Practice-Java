/**
 * Problem: Container With Most Water
 * Link: https://leetcode.com/problems/container-with-most-water/
 * * Time Complexity: O(n) - Single pass using two pointers moving inward.
 * Space Complexity: O(1) - Only tracking max area and pointer variables.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentWater = currentWidth * currentHeight;

            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}