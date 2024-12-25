class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int maxNode = Integer.MIN_VALUE;

            while (n-- > 0) {
                maxNode = Math.max(maxNode, queue.peek().val);
                TreeNode currNode = queue.poll();

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            list.add(maxNode);
        }

        return list;
    }
}
