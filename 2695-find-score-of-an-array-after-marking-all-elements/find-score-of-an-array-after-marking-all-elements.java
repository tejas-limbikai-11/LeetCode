class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        long result = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        boolean[] marked = new boolean[n];

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int score = curr[0];
            int idx = curr[1];

            if (!marked[idx]) {
                result += score;
                marked[idx] = true;
                if (idx > 0 && !marked[idx - 1]) {
                    marked[idx - 1] = true;
                }
                if (idx < n - 1 && !marked[idx + 1]) {
                    marked[idx + 1] = true;
                }
            }
        }
        return result;
    }
}
