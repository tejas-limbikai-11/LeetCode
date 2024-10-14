class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr=  new int[2];

        for(int idx = n-1; idx >= 0; idx--) {
            for(int canBuy = 0; canBuy <= 1; canBuy++) {
                if(canBuy == 1) {
                    int buy = ahead[0] - prices[idx];
                    int notBuy = ahead[1];
                    curr[canBuy] = Math.max(buy, notBuy);
                }
                else {
                    int sell = ahead[1] + prices[idx] - fee;
                    int notSell = ahead[0];
                    curr[canBuy] = Math.max(sell, notSell);
                }
            }
            ahead = curr.clone();
        }

        return ahead[1];
    }
}