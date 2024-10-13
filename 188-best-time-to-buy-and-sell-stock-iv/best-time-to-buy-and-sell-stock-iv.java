class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int[][] d: dp) {
            for(int[] d2: d) {
                Arrays.fill(d2, -1);
            }
        }
        return solve(0, 1, k, prices, dp);
    }

    public int solve(int idx, int canBuy, int cap, int[] prices, int[][][] dp) {
        if(cap == 0 || idx == prices.length) return 0;

        if(dp[idx][canBuy][cap] != -1) {
            return dp[idx][canBuy][cap];
        }

        if(canBuy == 1) {
            int buy = solve(idx + 1, 0, cap, prices, dp) - prices[idx];
            int notBuy = solve(idx + 1, 1, cap, prices, dp);
            return dp[idx][canBuy][cap] = Math.max(buy, notBuy);
        }
        else {
            int sell = solve(idx + 1, 1, cap - 1, prices ,dp) + prices[idx];
            int notSell = solve(idx + 1, 0, cap, prices, dp);
            return dp[idx][canBuy][cap] = Math.max(sell, notSell);
        }
    }
}