/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        mirror(root);
        return root;
    }

    private void mirror(TreeNode node) {
        TreeNode right = null;
        TreeNode left = null;
        if (node.right != null) {
            right = node.right;
        }
        if (node.left != null) {
            left = node.left;
        }
        node.left = right;
        node.right = left;

        if (right != null) {
            mirror(right);
        }
        if (left != null) {
            mirror(left);
        }
    }
}