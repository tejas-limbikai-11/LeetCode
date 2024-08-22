class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(long[] d: dp) Arrays.fill(d, -1);

        return solve(0, true, nums, dp);
    }

    public long solve(int idx, boolean flag, int[] nums, long[][] dp) {
        if(idx >= nums.length) return 0;

        int flagIdx = (flag) ? 1 : 0;  //true -> 1 | false -> 0
        if(dp[idx][flagIdx] != -1) {
            return dp[idx][flagIdx];
        }

        long skip = solve(idx + 1, flag, nums, dp);

        int value = nums[idx];
        if(!flag) value *= -1;

        long take = value + solve(idx + 1, !flag, nums, dp);

        return dp[idx][flagIdx] = Math.max(skip, take);
    }
}