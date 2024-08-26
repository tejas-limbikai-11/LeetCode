class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int[] d: dp) Arrays.fill(d, Integer.MIN_VALUE);
        return solve(0, 0, nums1, nums2, dp);
    }

    public int solve(int idx1, int idx2, int[] nums1, int[] nums2, int[][] dp) {
        if(idx1 >= nums1.length || idx2 >= nums2.length) return Integer.MIN_VALUE;

        if(dp[idx1][idx2] != Integer.MIN_VALUE) {
            return dp[idx1][idx2];
        }

        int take = (nums1[idx1] * nums2[idx2]) + Math.max(solve(idx1 + 1, idx2 + 1, nums1, nums2, dp), 0);
        int skip1 = solve(idx1 + 1, idx2, nums1, nums2, dp);
        int skip2 = solve(idx1, idx2 + 1, nums1, nums2, dp);

        return dp[idx1][idx2] = Math.max(take, Math.max(skip1, skip2));
    }
}