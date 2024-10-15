class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for(int idx = 0; idx < n; idx++) {
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[prevIdx] < nums[idx]) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[prevIdx]);
                }
            }
            maxLIS = Math.max(maxLIS, dp[idx]); 
        }
        return maxLIS;
    }
}