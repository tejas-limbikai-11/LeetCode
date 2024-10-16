class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        int[] bitonic = new int[n];
        
        for(int idx = 0; idx < n; idx++) {
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[idx] > nums[prevIdx]) {
                    dp1[idx] = Math.max(dp1[idx], 1 + dp1[prevIdx]);
                }
            }
        }
        
        for(int idx = n-1; idx >= 0; idx--) {
            for(int prevIdx = n-1; prevIdx > idx; prevIdx--) {
                if(nums[idx] > nums[prevIdx]) {
                    dp2[idx] = Math.max(dp2[idx], 1 + dp2[prevIdx]);
                }
            }
        }
        
        int length = 0;
        for(int i=0; i<n; i++) {
            if(dp1[i] > 1 && dp2[i] > 1) {
                bitonic[i] = dp1[i] + dp2[i] - 1;
                length = Math.max(length, bitonic[i]);
            }
        }
        return n - length;
    }
}   