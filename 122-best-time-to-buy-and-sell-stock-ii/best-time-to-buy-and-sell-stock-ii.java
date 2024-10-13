class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadNotBuy = 0;
        int aheadBuy = 0;
        int currNotBuy = 0;
        int currBuy = 0;

        aheadNotBuy = aheadBuy = 0;    

        for(int idx = n-1; idx >= 0; idx--) {
            currBuy = Math.max(aheadNotBuy - prices[idx], aheadBuy);
            currNotBuy = Math.max(aheadBuy + prices[idx], aheadNotBuy);
            
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}