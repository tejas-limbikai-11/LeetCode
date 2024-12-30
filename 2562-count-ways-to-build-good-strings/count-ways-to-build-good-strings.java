class Solution {
    final int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return solve(0, low, high, zero, one, dp);
    }

    public int solve(int length, int low, int high, int zero, int one, int[] dp) {
        if (length > high)
            return 0;

        if(dp[length] != -1) {
            return dp[length];
        }

        boolean addOne = false;
        if (length >= low && length <= high) {
            addOne = true;
        }

        int appendZero = solve(length + zero, low, high, zero, one, dp);
        int appendOne = solve(length + one, low, high, zero, one, dp);

        return dp[length] = (appendZero + appendOne + (addOne ? 1 : 0)) % MOD;
    }
}
