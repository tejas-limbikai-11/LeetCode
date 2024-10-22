class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxLIS = 1;

        for(int idx = 0; idx < n; idx++) {
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[prevIdx] < nums[idx]) {
                    if(dp[idx] == 1 + dp[prevIdx]) {
                        count[idx] += count[prevIdx];
                    }
                    else if(1 + dp[prevIdx] > dp[idx]) {
                        dp[idx] = 1 + dp[prevIdx];
                        count[idx] = count[prevIdx];
                    }
                }
            }
            maxLIS = Math.max(maxLIS, dp[idx]);
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            if(dp[i] == maxLIS) {
                result += count[i];
            }
        }
        return result;
    }
}