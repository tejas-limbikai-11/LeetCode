class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        
        //if(cap == 0) return 0;
        for(int idx = 0; idx < n; idx++) {
            for(int canBuy = 0; canBuy <= 1; canBuy++) {
                dp[idx][canBuy][0] = 0;
            }
        }

        //if(idx == n) return 0;
        for(int canBuy = 0; canBuy <= 1; canBuy++) {
            for(int cap = 0; cap <= 2; cap++) {
                dp[n][canBuy][cap] = 0;
            }
        }

        for(int idx = n-1; idx >= 0; idx--) {
            for(int canBuy = 0; canBuy <= 1; canBuy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(canBuy == 1) {
                        int buy = dp[idx + 1][0][cap] - prices[idx];
                        int notBuy = dp[idx + 1][1][cap];
                        dp[idx][canBuy][cap] = Math.max(buy, notBuy);
                    }
                    else {
                        int sell = dp[idx + 1][1][cap - 1] + prices[idx];
                        int notSell = dp[idx + 1][0][cap];
                        dp[idx][canBuy][cap] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}