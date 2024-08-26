class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        for(int target=0; target<=amount; target++) {
            if(target  % coins[0] == 0) dp[target] = target / coins[0];
            else dp[target] = (int) 1e9;
        }

        for(int idx=1; idx<n; idx++) {
            for(int target=0; target<=amount; target++) {
                int skip = dp[target];

                int take = Integer.MAX_VALUE;
                if(coins[idx] <= target) {
                    take = 1 + dp[target - coins[idx]];
                }
                dp[target] = Math.min(take ,skip);
            }
        }

        int ans = dp[amount];

        if(ans >= 1e9) return -1;
        return ans;
    }
}