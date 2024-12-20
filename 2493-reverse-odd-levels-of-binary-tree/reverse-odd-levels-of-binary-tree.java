class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1);
        return root;
    }

    public void solve(TreeNode L, TreeNode R, int level) {
        if(L == null || R == null) return;
        
        if(level % 2 == 1) {
            int temp = L.val;
            L.val = R.val;
            R.val = temp;
        }

        solve(L.left, R.right, level + 1);
        solve(L.right, R.left, level + 1);
    }
}
