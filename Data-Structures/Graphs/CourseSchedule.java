/**
 * Problem: Course Schedule
 * Link: https://leetcode.com/problems/course-schedule/
 * * Time Complexity: O(V + E) - Where V is courses and E is prerequisites.
 * Space Complexity: O(V + E) - Space for the adjacency list and queue.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list and compute indegrees
        for (int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // Add all courses with 0 prerequisites (indegree == 0)
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completedCourses = 0;

        // Process courses using BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If we completed all courses, no cycle exists
        return completedCourses == numCourses;
    }
}