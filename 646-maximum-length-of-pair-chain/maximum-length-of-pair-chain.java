class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}