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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int qsize = q.size();
            for(int i=0; i<qsize; i++) {
                TreeNode currNode = q.remove();
                list.add(currNode.val);
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            result.add(list);
        }

        return result;
    }
}