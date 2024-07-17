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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i: to_delete) set.add(i);

        if(!set.contains(root.val)) result.add(root);
        deleteHelper(root, set, result);
        
        return result;
    }

    public TreeNode deleteHelper(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if(root == null) return null;

        root.left = deleteHelper(root.left, set, result);
        root.right = deleteHelper(root.right, set, result);

        if(set.contains(root.val)) {
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
            return null;
        }
        else return root;
    }
}