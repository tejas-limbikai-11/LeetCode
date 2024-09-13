class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        if((target + totalSum) % 2 != 0 || totalSum < target || totalSum + target < 0) {
            return 0;
        }
        
        int sum = (totalSum + target) / 2;
        int[][] dp = new int[n + 1][sum + 1];
        
        for(int j=0; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}