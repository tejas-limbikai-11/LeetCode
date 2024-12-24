class Solution {
    public int minimumOperations(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();

            while(n-- > 0) {
                TreeNode curr = queue.poll();
                list.add(curr.val);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            result += minSwapsSortArray(list);
        }
        return result;
    }

    public int minSwapsSortArray(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<sortedList.size(); i++) {
            map.put(sortedList.get(i), i);
        }

        int swaps = 0;
        for(int i=0; i<list.size(); i++) {
            while(map.get(list.get(i)) != i) {
                Collections.swap(list, i, map.get(list.get(i)));
                swaps++;
            }
        }
        return swaps;
    }
}
