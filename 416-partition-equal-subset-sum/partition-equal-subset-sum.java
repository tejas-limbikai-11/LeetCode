class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if(totalSum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[n + 1][totalSum / 2 + 1];
        return subsetSum(nums, totalSum / 2, n, dp);
    }

    public boolean subsetSum(int arr[], int sum, int n, Boolean[][] dp) {
        if((n == 0 && sum == 0) || sum == 0) return true;
        else if(n == 0) return false;

        if(dp[n][sum] != null) {
            return dp[n][sum];
        }

        if(arr[n-1] <= sum) {
            return dp[n][sum] = subsetSum(arr, sum - arr[n-1], n-1, dp) 
                || subsetSum(arr, sum, n-1, dp);
        }
        else {
            return dp[n][sum] = subsetSum(arr, sum, n-1, dp);
        }
    }
}