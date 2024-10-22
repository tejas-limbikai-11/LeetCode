class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            pq.offer(sum);

            if(pq.size() > k) pq.poll();
        }

        if(k > pq.size()) return -1;

        return pq.peek();
    }
}