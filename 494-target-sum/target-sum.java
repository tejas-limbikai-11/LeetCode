class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums) totalSum += num;

        if (target > totalSum || target < -totalSum) return 0;

        int[][] dp = new int[n + 1][2 * totalSum + 1];
        dp[n][totalSum] = 1;

        for(int idx=n-1; idx>=0; idx--) {
            for(int sum=-totalSum; sum<=totalSum; sum++) {
                int adjustedSum = sum + totalSum;
                int negative = (adjustedSum - nums[idx] >= 0) ? dp[idx + 1][adjustedSum - nums[idx]] : 0;
                int positive = (adjustedSum + nums[idx] < 2 * totalSum + 1) ? dp[idx + 1][adjustedSum + nums[idx]] : 0;

                dp[idx][adjustedSum] = negative + positive;
            }
        }
        return dp[0][target + totalSum];
    }
}