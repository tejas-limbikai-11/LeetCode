class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(0, -1, nums, dp);
    }

    public int solve(int idx, int prevIdx, int[] nums, int[][] dp) {
        if(idx >= nums.length) return 0;

        if(prevIdx != -1 && dp[idx][prevIdx] != -1) {
            return dp[idx][prevIdx];
        }

        int take = -1;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + solve(idx + 1, idx, nums, dp);
        }
        int skip = solve(idx + 1, prevIdx, nums, dp);

        if(prevIdx != -1) {
            dp[idx][prevIdx] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }
}