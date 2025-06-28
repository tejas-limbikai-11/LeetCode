class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Step 1: Min-heap to keep top-k largest elements (value, index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 2: Collect the indices of the top-k largest elements
        Set<Integer> indices = new HashSet<>();
        while (!minHeap.isEmpty()) {
            indices.add(minHeap.poll()[1]);
        }

        // Step 3: Construct the result using only the elements with those indices, in order
        int[] result = new int[k];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indices.contains(i)) {
                result[pos++] = nums[i];
            }
        }

        return result;
    }
}