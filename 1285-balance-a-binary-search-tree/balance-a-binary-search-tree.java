class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> bst = new ArrayList<>();
        inorder(root, bst);
        TreeNode ans = createBST(bst, 0, bst.size()-1);
        return ans;
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> bst) {
        if(root == null) return;
        inorder(root.left, bst);
        bst.add(root);
        inorder(root.right, bst);
    }

    public TreeNode createBST(ArrayList<TreeNode> bst, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode((bst.get(mid)).val);
        root.left = createBST(bst, start, mid-1);
        root.right = createBST(bst, mid+1, end);
        return root;
    }
}