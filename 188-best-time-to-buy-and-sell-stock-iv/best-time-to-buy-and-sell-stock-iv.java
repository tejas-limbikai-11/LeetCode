class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] after = new int[2*k+1];
        int[] curr = new int[2*k+1];

        for(int idx = n-1; idx >=0; idx--) {
            for(int transacNo = 2 * k - 1; transacNo >= 0; transacNo--) {
                if(transacNo % 2 == 0) {
                    int buy = after[transacNo + 1] - prices[idx];
                    int notBuy = after[transacNo];
                    curr[transacNo] = Math.max(buy, notBuy);
                }
                else {
                    int sell = after[transacNo + 1] + prices[idx];
                    int notSell = after[transacNo];
                    curr[transacNo] = Math.max(sell, notSell);
                }
            }
            after = curr;
        }
        return after[0];
    }
}