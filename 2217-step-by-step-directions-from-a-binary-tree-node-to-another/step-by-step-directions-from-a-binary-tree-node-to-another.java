class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lowestCommonAncestor(root, startValue, destValue);

        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        findPath(LCA, startValue, lcaToStart);
        findPath(LCA, destValue, lcaToDest);

        StringBuilder result = new StringBuilder();

        for(int i=0; i<lcaToStart.length(); i++) {
            result.append('U');
        }
        result.append(lcaToDest);
        return result.toString();
    }

    public boolean findPath(TreeNode node, int target, StringBuilder path) {
        if(node == null) return false;
        if(node.val == target) return true;

        path.append('L');
        if(findPath(node.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if(findPath(node.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null || root.val == p || root.val == q) return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if(leftLCA == null) return rightLCA;
        if(rightLCA == null) return leftLCA;

        return root;
    }
}