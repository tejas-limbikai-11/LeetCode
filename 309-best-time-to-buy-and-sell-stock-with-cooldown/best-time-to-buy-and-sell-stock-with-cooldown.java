class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(0, 1, prices, dp);
    }

    public int solve(int idx, int canBuy, int[] prices, int[][] dp) {
        if(idx >= prices.length) return 0;

        if(dp[idx][canBuy] != -1) {
            return dp[idx][canBuy];
        }

        if(canBuy == 1) {
            int buy = solve(idx + 1, 0, prices, dp) - prices[idx];
            int notBuy = solve(idx + 1, 1, prices, dp);
            return dp[idx][canBuy] = Math.max(buy, notBuy);
        }
        else {
            int sell = solve(idx + 2, 1, prices, dp) + prices[idx];
            int notSell = solve(idx + 1, 0,prices, dp);
            return dp[idx][canBuy] = Math.max(sell, notSell);
        }
    }
}