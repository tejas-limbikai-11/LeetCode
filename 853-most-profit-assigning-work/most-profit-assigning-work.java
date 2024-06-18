class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        int maxProfit = 0;

        for(int i=0; i<m; i++) {
            int currProfit = 0;
            for(int j=0; j<n; j++) {
                if(difficulty[j] <= worker[i]) {
                    currProfit = Math.max(currProfit, profit[j]);
                }
            }
            maxProfit += currProfit;
        }
        return maxProfit;
    }
}