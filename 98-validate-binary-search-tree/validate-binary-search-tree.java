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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);

        for(int i=0; i<result.size()-1; i++) {
            if(result.get(i) >= result.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}