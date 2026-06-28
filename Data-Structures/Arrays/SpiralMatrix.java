/**
 * Problem: Spiral Matrix
 * Link: https://leetcode.com/problems/spiral-matrix/
 * * Time Complexity: O(m * n) - Every element in the matrix is visited exactly once.
 * Space Complexity: O(1) - Constant auxiliary space (excluding the output list).
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse from Left to Right along the top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Move top boundary down

            // 2. Traverse from Top to Bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            // 3. Traverse from Right to Left along the bottom row (if valid)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4. Traverse from Bottom to Top along the left column (if valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }
}