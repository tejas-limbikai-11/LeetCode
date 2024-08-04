class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int mod = 1_000_000_007;

        for(int i=0; i<n; i++) {
            pq.offer(new int[] {nums[i], i});
        }

        int result = 0;

        for(int i=1; i<=right; i++) {
            int[] curr = pq.poll();
            int sum = curr[0];
            int idx = curr[1];

            if(i >= left) {
                result = (result + sum) % mod;
            }

            if(curr[1] < n-1) {
                pq.offer(new int[] {sum + nums[idx + 1], idx + 1});
            }
        }
        return result;
    }
}