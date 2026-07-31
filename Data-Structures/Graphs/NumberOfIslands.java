/**
 * Problem: Number of Islands
 * Link: https://leetcode.com/problems/number-of-islands/
 * * Time Complexity: O(M * N) - Every cell in the grid is visited a constant number of times.
 * Space Complexity: O(M * N) - Worst-case call stack depth for grid fully filled with land.
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c); // Sink all connected land
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base cases: Out of bounds or current cell is water ('0')
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark current cell as visited by sinking it
        grid[r][c] = '0';

        // Recursively visit all 4 adjacent directions
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}