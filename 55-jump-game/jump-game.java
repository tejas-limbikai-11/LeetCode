class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--) {
            int steps = nums[i];
            int jumps = Integer.MAX_VALUE;
            for(int j=i+1; j<=(i+steps) && j<n; j++) {
                if(dp[j] != -1) jumps = Math.min(jumps, dp[j] + 1);
            }
            if(jumps != Integer.MAX_VALUE) dp[i] = jumps;
        }
        return dp[0] != -1;
    }
}