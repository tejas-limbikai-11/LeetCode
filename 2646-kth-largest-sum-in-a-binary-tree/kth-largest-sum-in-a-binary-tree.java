class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> list = new ArrayList<>();

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
            list.add(sum);
        }

        Collections.sort(list, Collections.reverseOrder());

        if(k > list.size()) return -1;

        return list.get(k-1);
    }
}