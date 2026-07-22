/**
 * Problem: Lowest Common Ancestor of a Binary Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * * Time Complexity: O(n) - We might visit every node in the worst case.
 * Space Complexity: O(h) - Auxiliary space used by the call stack, where h is height.
 */

public class LowestCommonAncestor {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: If root is null, or matches p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q are found in different subtrees, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null result (whichever subtree contains the LCA/node)
        return left != null ? left : right;
    }
}