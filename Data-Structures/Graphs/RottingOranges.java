/**
 * Problem: Rotting Oranges
 * Link: https://leetcode.com/problems/rotting-oranges/
 * * Time Complexity: O(M * N) - Every cell in the grid is processed at most once.
 * Space Complexity: O(M * N) - Queue space for grid storage in the worst case.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize queue with all rotten oranges & count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: Multi-source BFS
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // If neighbor is within bounds and is a fresh orange
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Rot the fresh orange
                        freshCount--;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}