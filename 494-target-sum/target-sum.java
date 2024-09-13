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
        for(int[] d: dp) Arrays.fill(d, -1);

        return solve(n, sum, nums, dp);
    }

    public int solve(int n, int sum, int[] nums, int[][] dp) {
        if(n == 0 && sum == 0) return 1;
        else if(n == 0) return 0;

        if(dp[n][sum] != -1) {
            return dp[n][sum];
        }

        if(nums[n-1] <= sum) {
            int take = solve(n-1, sum - nums[n-1], nums, dp);
            int notTake = solve(n-1, sum, nums, dp);
            return dp[n][sum] = (take + notTake);
        }
        else return dp[n][sum] = solve(n-1, sum, nums, dp);
    }
}