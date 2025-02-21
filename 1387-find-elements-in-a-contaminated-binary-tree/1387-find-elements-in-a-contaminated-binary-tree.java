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
class FindElements {

    Set<Integer> values = new HashSet<>(List.of(0));

    public FindElements(TreeNode root) {
        root.val = 0;
        purify(root);
    }

    private void purify(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            int val = node.val * 2 + 1;
            values.add(val);
            node.left.val = val;
            purify(node.left);
        }

        if (node.right != null) {
            int val = node.val * 2 + 2;
            values.add(val);
            node.right.val = val;
            purify(node.right);
        }
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */