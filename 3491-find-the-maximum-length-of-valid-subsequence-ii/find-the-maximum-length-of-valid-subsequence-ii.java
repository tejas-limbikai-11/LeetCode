class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[k][n];
        for(int[] d: dp) {
            Arrays.fill(d, 1);
        }

        int maxLength = 1;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                int mod = (nums[j] + nums[i]) % k;

                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                maxLength = Math.max(maxLength, dp[mod][i]);
            }
        }

        return maxLength;
    }
}