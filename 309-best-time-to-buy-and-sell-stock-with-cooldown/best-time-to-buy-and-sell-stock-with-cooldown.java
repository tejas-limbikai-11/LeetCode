class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int idx = n-1; idx >= 0; idx--) {
            for(int canBuy = 0; canBuy <= 1; canBuy++) {
                if(canBuy == 1) {
                    int buy = dp[idx + 1][0] - prices[idx];
                    int notBuy = dp[idx + 1][1];
                    dp[idx][canBuy] = Math.max(buy, notBuy);
                }
                else {
                    int sell = (idx + 2 <= n) ? dp[idx + 2][1] + prices[idx] : prices[idx];
                    int notSell = dp[idx + 1][0];
                    dp[idx][canBuy] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }
}