class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelSum = new ArrayList<>();
        queue.offer(root);

        //Step 1 - Find sum of each level
        while(!queue.isEmpty()) {
            int currLevelSum = 0;
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                currLevelSum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            levelSum.add(currLevelSum);
        }

        //Step 2 - Update value of each node
        queue.offer(root);
        root.val = 0;
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                int siblingsSum = 0;
                siblingsSum += node.left != null ? node.left.val : 0;
                siblingsSum += node.right != null ? node.right.val : 0;

                if(node.left != null) {
                    node.left.val = levelSum.get(level) - siblingsSum;
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    node.right.val = levelSum.get(level) - siblingsSum;
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return root;
    }
}