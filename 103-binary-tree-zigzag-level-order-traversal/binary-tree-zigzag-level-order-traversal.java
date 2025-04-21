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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();  
        if(root == null) return result;
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();

            for(int i=0; i<n; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            if(leftToRight) leftToRight = false;
            else {
                Collections.reverse(list);
                leftToRight = true;
            }

            result.add(list);
        }
        return result;
    }
}