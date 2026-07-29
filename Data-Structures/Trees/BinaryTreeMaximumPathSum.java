/**
 * Problem: Binary Tree Maximum Path Sum
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * * Time Complexity: O(n) - We visit every node in the binary tree exactly once.
 * Space Complexity: O(h) - Auxiliary space used by recursion stack where h is tree height.
 */

public class BinaryTreeMaximumPathSum {
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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculateMaxGain(root);
        return maxSum;
    }

    private int calculateMaxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ignore negative paths by taking Math.max(..., 0)
        int leftGain = Math.max(calculateMaxGain(node.left), 0);
        int rightGain = Math.max(calculateMaxGain(node.right), 0);

        // Path sum including the current node as the highest structural curve root
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global max path sum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum single branch contribution upward to parent
        return node.val + Math.max(leftGain, rightGain);
    }
}