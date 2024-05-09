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
    public int maxDepth(TreeNode root) {
        int answer = 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode treeNode, int index) {
        if (treeNode == null) {
            return index;
        }

        return Math.max(dfs(treeNode.left, index + 1), dfs(treeNode.right, index + 1));
    }
}