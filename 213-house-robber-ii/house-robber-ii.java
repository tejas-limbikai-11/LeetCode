class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp[] = new int[n+1];

        for(int i=1; i<n; i++) {
            int rob = nums[i-1] + ((i >= 2) ? dp[i-2] : 0);
            int skip = dp[i-1];
            dp[i] = Math.max(rob, skip);
        }
        int FirstHouseRobbed = dp[n-1];

        Arrays.fill(dp, 0);

        for(int i=2; i<=n; i++) {
            int rob = nums[i-1] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(rob, skip);
        }
        int FirstHouseNotRobbed = dp[n];

        return Math.max(FirstHouseRobbed, FirstHouseNotRobbed);
    }
}