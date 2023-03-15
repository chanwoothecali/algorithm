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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                if (end) {
                    return false;
                }
                queue.offer(current.left);
            } else {
                end = true;
            }

            if (current.right != null) {
                if (end) {
                    return false;
                }
                queue.offer(current.right);
            } else {
                end = true;
            }
        }

        return true;
    }
}