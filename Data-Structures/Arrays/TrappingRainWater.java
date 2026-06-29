/**
 * Problem: Trapping Rain Water
 * Link: https://leetcode.com/problems/trapping-rain-water/
 * * Time Complexity: O(n) - Single pass using two pointers meeting in the middle.
 * Space Complexity: O(1) - Constant auxiliary space.
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Process the side with the smaller structural boundary
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left boundary
                } else {
                    totalWater += leftMax - height[left]; // Add trapped water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right boundary
                } else {
                    totalWater += rightMax - height[right]; // Add trapped water
                }
                right--;
            }
        }

        return totalWater;
    }
}