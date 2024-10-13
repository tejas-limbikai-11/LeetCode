class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for(int idx = n-1; idx >= 0; idx--) {
            for(int canBuy = 0; canBuy <= 1; canBuy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(canBuy == 1) {
                        int buy = after[0][cap] - prices[idx];
                        int notBuy = after[1][cap];
                        curr[canBuy][cap] = Math.max(buy, notBuy);
                    }
                    else {
                        int sell = after[1][cap - 1] + prices[idx];
                        int notSell = after[0][cap];
                        curr[canBuy][cap] = Math.max(sell, notSell);
                    }
                }
            }
            after = curr;
        }
        return after[1][2];
    }
}