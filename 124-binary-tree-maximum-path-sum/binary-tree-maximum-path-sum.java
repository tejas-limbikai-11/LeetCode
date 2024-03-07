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
    int val;

    public int maxPathSum(TreeNode root) {
        val = Integer.MIN_VALUE;
        findPathSum(root);
        return val;
    }

    public int findPathSum(TreeNode root) {
        if(root == null) return 0;

        // Max sum in left subtree
        int leftSum = findPathSum(root.left);
        // Max sum in right subtree
        int rightSum = findPathSum(root.right);

        // Max sum height starting from this node
        int maxSingle =  Math.max(Math.max(leftSum, rightSum) + root.val, root.val);

        // Max sum path containing this node.
        int maxTotal = Math.max(maxSingle, leftSum + rightSum + root.val);

        val = Math.max(val, maxTotal);

        return maxSingle;
    }
}