class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for(int coin: coins) {
            for(int j=coin; j<amount+1; j++) {
                dp[j] = Math.min(1 + dp[j - coin], dp[j]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}