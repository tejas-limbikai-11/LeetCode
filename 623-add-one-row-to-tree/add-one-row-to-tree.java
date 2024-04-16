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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        int curr = 1;
        return DFS(root, val, depth, curr);
    }

    public TreeNode DFS(TreeNode root, int val, int depth, int curr) {
        if(root == null) return null;
        if(curr == depth - 1) {
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = tempLeft;
            root.right.right = tempRight;

            return root;
        }
        root.left = DFS(root.left, val, depth, curr + 1);
        root.right = DFS(root.right, val, depth, curr + 1);
        
        return root;
    }
}