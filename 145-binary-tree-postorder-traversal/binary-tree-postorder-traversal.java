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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraverse(root, list);
        return list;
    }

    public void postorderTraverse(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        postorderTraverse(root.left, list);
        postorderTraverse(root.right, list);
        list.add(root.val);
    }
}