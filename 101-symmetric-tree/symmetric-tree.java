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
    public boolean isSymmetric(TreeNode root) {
        return areMirror(root.left, root.right);
    }

    public boolean areMirror(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        else if(a == null || b == null || a.val != b.val) return false;

        if(!areMirror(a.left, b.right)) return false;
        if(!areMirror(a.right, b.left)) return false;

        return true;
    }

}