class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums) totalSum += num;

        int[][] dp = new int[n][2 * totalSum + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(0, 0, target, nums, dp, totalSum);
    }

    public int solve(int idx, int sum, int target, int[] nums, int[][] dp, int totalSum) {
        if(idx >= nums.length) {
            if(sum == target) return 1;
            else return 0;
        }

        if(dp[idx][sum + totalSum] != -1) return dp[idx][sum + totalSum];

        int negative = solve(idx + 1, sum - nums[idx], target, nums, dp, totalSum);
        int positive = solve(idx + 1, sum + nums[idx], target, nums, dp, totalSum);

        return dp[idx][sum + totalSum] = negative + positive;
    }
}