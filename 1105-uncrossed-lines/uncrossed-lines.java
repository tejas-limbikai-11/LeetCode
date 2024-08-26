class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] d: dp) Arrays.fill(d, -1);

        return solve(0, 0, nums1, nums2, dp);   
    }

    public int solve(int idx1, int idx2, int[] nums1, int[] nums2, int[][] dp) {
        if(idx1 >= nums1.length || idx2 >= nums2.length) return 0;

        if(dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if(nums1[idx1] == nums2[idx2]) {
            return dp[idx1][idx2] = 1 + solve(idx1 + 1, idx2 + 1, nums1, nums2, dp);
        }

        int skip1 = solve(idx1 + 1, idx2, nums1, nums2, dp);
        int skip2 = solve(idx1, idx2 + 1, nums1, nums2, dp);

        return dp[idx1][idx2] = Math.max(skip1, skip2);
    }
}