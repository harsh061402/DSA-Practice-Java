/**
 * Problem: Maximum Depth of Binary Tree
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * * Time Complexity: O(n) - We visit every node exactly once to compute its depth contribution.
 * Space Complexity: O(h) - Call stack memory proportional to the height of the binary tree.
 */

public class MaximumDepthOfBinaryTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        // Base Case: If the node is null, the depth contribution is 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is 1 plus the maximum of its children's depths
        return Math.max(leftDepth, rightDepth) + 1;
    }
}