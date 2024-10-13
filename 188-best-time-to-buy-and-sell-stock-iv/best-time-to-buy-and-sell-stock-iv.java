class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];

        for(int idx = n-1; idx >=0; idx--) {
            for(int transacNo = 2 * k - 1; transacNo >= 0; transacNo--) {
                if(transacNo % 2 == 0) {
                    int buy = dp[idx + 1][transacNo + 1] - prices[idx];
                    int notBuy = dp[idx + 1][transacNo];
                    dp[idx][transacNo] = Math.max(buy, notBuy);
                }
                else {
                    int sell = dp[idx + 1][transacNo + 1] + prices[idx];
                    int notSell = dp[idx + 1][transacNo];
                    dp[idx][transacNo] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][0];
    }
}