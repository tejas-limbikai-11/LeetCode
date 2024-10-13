class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return solve(0, 0, k, prices, dp);
    }

    public int solve(int idx, int transacNo, int k, int[] prices, int[][] dp) {
        if(transacNo == 2 * k || idx == prices.length) return 0;

        if(dp[idx][transacNo] != -1) {
            return dp[idx][transacNo];
        }

        if(transacNo % 2 == 0) {
            int buy = solve(idx + 1, transacNo + 1, k, prices, dp) - prices[idx];
            int notBuy = solve(idx + 1, transacNo, k, prices, dp);
            return dp[idx][transacNo] = Math.max(buy, notBuy);
        }
        else {
            int sell = solve(idx + 1, transacNo + 1, k, prices ,dp) + prices[idx];
            int notSell = solve(idx + 1, transacNo, k, prices, dp);
            return dp[idx][transacNo] = Math.max(sell, notSell);
        }
    }
}