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
    public String smallestFromLeaf(TreeNode root) {
        return helper(root, "");
    }

    public String helper(TreeNode root, String str) {
        if(root == null) return str;

        str = (char)('a' + root.val) + str; 
        if(root.left != null && root.right != null) {
            String left = helper(root.left, str);
            String right = helper(root.right, str);
            if(left.compareTo(right) < 0) return left;
            else return right;
        }
        if(root.left == null) return helper(root.right, str);
        if(root.right == null) return helper(root.left, str);
        
        return str;
    }
}