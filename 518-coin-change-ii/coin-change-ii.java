class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(n, amount, coins, dp);
    }

    public static int solve(int n, int sum, int coins[], int[][] dp) {
        if(n == 0 && sum == 0 || sum == 0) return 1;
        else if(n == 0) return 0;

        if(dp[n][sum] != -1) {
            return dp[n][sum];
        }

        int take = 0;
        if(coins[n-1] <= sum) {
            take = solve(n, sum - coins[n-1], coins, dp);
        }
        int notTake = solve(n-1, sum, coins, dp);

        return dp[n][sum] = take + notTake;
    }
}