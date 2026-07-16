/**
 * Problem: Diameter of Binary Tree
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
 * * Time Complexity: O(n) - Every node in the tree is visited exactly once.
 * Space Complexity: O(h) - Where h is the height of the tree, due to the call stack depth.
 */

public class DiameterOfBinaryTree {
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

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively compute the heights of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current subtree to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
}