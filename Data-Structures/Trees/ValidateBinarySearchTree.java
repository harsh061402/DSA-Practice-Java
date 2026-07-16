/**
 * Problem: Validate Binary Search Tree
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 * * Time Complexity: O(n) - We check every node exactly once.
 * Space Complexity: O(h) - Recursive call stack proportional to the height of the tree.
 */

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // Base Case: An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // The current node's value must stay strictly within the low and high boundaries
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        // Recursively validate left and right subtrees with updated constraints
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}