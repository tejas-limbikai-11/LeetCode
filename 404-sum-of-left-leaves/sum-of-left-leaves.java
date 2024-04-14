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
    public int sumOfLeftLeaves(TreeNode root) {
        return leftSum(root, false);
    }

    public int leftSum(TreeNode curr, boolean isLeft) {
        if(curr == null) return 0;
        if(curr.left == null && curr.right == null && isLeft == true) {
            return curr.val;
        }
        return leftSum(curr.left, true) + leftSum(curr.right, false);
    }
}