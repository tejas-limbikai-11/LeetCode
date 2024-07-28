class Solution {
    public int maxProfit(int[] prices) {
        List<Integer> list  = new ArrayList<>();
        int maxProfit = 0;

        int x = prices[0];
        for(int i=0; i<prices.length - 1; i++) {
            if(prices[i+1] > prices[i]) {
                maxProfit += (prices[i+1] - prices[i]);
            }
        }   
        return maxProfit;
    }
}