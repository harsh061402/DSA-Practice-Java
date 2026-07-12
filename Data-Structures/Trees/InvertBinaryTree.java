/**
 * Problem: Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 * * Time Complexity: O(n) - Every node in the tree is visited exactly once.
 * Space Complexity: O(h) - Where h is the height of the tree, due to the call stack depth.
 */

public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        // Base Case: If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}   