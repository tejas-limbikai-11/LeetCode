class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;    //last day

        for(int idx = n-1; idx >= 0; idx--) {
            for(int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;

                if(canBuy == 1) {
                    int buy = dp[idx + 1][0] - prices[idx];
                    int notBuy = dp[idx + 1][1];
                    profit = Math.max(buy, notBuy);
                }
                else {
                    int sell = dp[idx + 1][1] + prices[idx];
                    int notSell = dp[idx + 1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[idx][canBuy] = profit;
            }
        }
        return dp[0][1];
    }
}