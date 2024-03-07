/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        int i = 0;
        while(i < path1.size() && i < path2.size()) {
            if(path1.get(i) != path2.get(i)) break;
            i++;
        }

        TreeNode lca = path1.get(i-1);
        return lca;
    }

    public boolean getPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if(root == null) return false;

        path.add(root);

        if(root.val == node.val) return true;

        boolean leftFound = getPath(root.left, node, path);
        boolean rightFound = getPath(root.right, node, path);

        if(leftFound || rightFound) return true;

        path.remove(path.size()-1);
        return false;
    }
}