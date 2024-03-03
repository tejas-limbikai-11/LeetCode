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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Info ans = diameter(root);
        return ans.diam;
    }

    public Info diameter(TreeNode root) {
        if(root == null) return new Info(0, 0);

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diam, height);
    }

    class Info{
        int diam;
        int height;

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }

    }
}