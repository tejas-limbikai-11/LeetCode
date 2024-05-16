class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val != 0; // Convert int to boolean
        }
        
        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        }
        
        return evaluateTree(root.left) & evaluateTree(root.right);
    }
}