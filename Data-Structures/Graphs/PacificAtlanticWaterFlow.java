/**
 * Problem: Pacific Atlantic Water Flow
 * Link: https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Time Complexity: O(M * N) - Every cell is visited at most a constant number of times.
 * Space Complexity: O(M * N) - Storage for the visited matrices and recursion call stack.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Perform DFS from ocean boundaries (top/bottom rows, left/right columns)
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]); // Left border (Pacific)
            dfs(heights, r, cols - 1, atlantic, heights[r][cols - 1]); // Right border (Atlantic)
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]); // Top border (Pacific)
            dfs(heights, rows - 1, c, atlantic, heights[rows - 1][c]); // Bottom border (Atlantic)
        }

        // Find cells reachable by both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Base cases: Out of bounds, already visited, or height is lower than previous (can't flow uphill)
        if (r < 0 || c < 0 || r >= rows || c >= cols || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        ocean[r][c] = true;

        dfs(heights, r + 1, c, ocean, heights[r][c]);
        dfs(heights, r - 1, c, ocean, heights[r][c]);
        dfs(heights, r, c + 1, ocean, heights[r][c]);
        dfs(heights, r, c - 1, ocean, heights[r][c]);
    }
}