class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] d: dp) Arrays.fill(d, -1);

        int ans = solve(n-1, amount, coins, dp);

        if(ans >= 1e9) return -1;
        return ans;
    }

    public int solve(int idx, int target, int[] coins, int[][] dp) {
        if(idx == 0) {
            if(target  % coins[0] == 0) return target / coins[0];
            else return (int) 1e9;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int skip = solve(idx - 1, target, coins, dp);

        int take = Integer.MAX_VALUE;
        if(coins[idx] <= target) {
            take = 1 + solve(idx, target - coins[idx], coins, dp);
        }
        return dp[idx][target] = Math.min(take ,skip);
    }
}