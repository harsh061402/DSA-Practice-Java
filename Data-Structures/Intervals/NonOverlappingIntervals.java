/**
 * Problem: Non-overlapping Intervals
 * Link: https://leetcode.com/problems/non-overlapping-intervals/
 * Time Complexity: O(n log n) - Sorting intervals by end times.
 * Space Complexity: O(1) - Constant auxiliary space (or O(log n) for sorting recursion).
 */

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end time in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap detected: remove the current interval to keep the one that ends earlier
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                // No overlap: update the boundary to the current interval's end
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}