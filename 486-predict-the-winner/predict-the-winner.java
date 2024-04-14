class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int d[]: dp) {
            Arrays.fill(d, (int) -1e9);
        }
        int diff = game(0, n-1, nums, dp);
        if(diff >= 0) return true;
        else return false;
    }

    public int game(int left, int right, int[] nums, int[][] dp) {
        if(left > right) return 0;
        if(dp[left][right] != (int) -1e9) return dp[left][right];

        int start = nums[left] - game(left + 1, right, nums, dp);
        int end = nums[right] - game(left, right - 1, nums, dp);
        return dp[left][right] = Math.max(start, end);
    }
}