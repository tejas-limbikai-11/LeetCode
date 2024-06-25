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
    public TreeNode bstToGst(TreeNode root) {
        morrisInorderTraversal(root);
        return root;
    }

    public void morrisInorderTraversal(TreeNode root) {
        int sum = 0;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.right == null) {
                sum += curr.val;
                curr.val = sum;
                curr = curr.left;
            }
            else {
                TreeNode prev = curr.right;
                while(prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }

                if(prev.left == null) {
                    prev.left = curr;
                    curr = curr.right;
                }
                else {
                    prev.left = null;
                    sum += curr.val;
                    curr.val = sum;
                    curr = curr.left;
                }
            }
        }
    }
}