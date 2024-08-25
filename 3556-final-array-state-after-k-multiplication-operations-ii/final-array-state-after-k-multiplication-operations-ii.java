class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(multiplier == 1) return nums;

        int n = nums.length;
        int maxNum = 0;
        for(int num: nums) maxNum = Math.max(maxNum, num);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        for(int i=0; i<n; i++) {
            pq.offer(new int[] {nums[i], i});
        }

        while(k > 0 && (long) multiplier * pq.peek()[0] <= maxNum) {
            k--;
            int val = (int) ((long) multiplier * pq.peek()[0] % MOD);
            int idx = pq.peek()[1];
            pq.poll();
            pq.offer(new int[] {val, idx});
        } 

        long pow = modpow(multiplier, k/n);

        while(!pq.isEmpty()) {
            int val = pq.peek()[0];
            int idx = pq.peek()[1];
            pq.poll();

            if(k % n > 0) {
                k--;
                nums[idx] = (int) (((multiplier * pow) % MOD * val) % MOD);
            }
            else nums[idx] = (int) ((pow * val) % MOD);
        }
        return nums;
    }


    public long modpow(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}