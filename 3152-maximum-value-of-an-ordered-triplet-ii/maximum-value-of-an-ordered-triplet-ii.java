class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }

        long result = 0;
        for(int i=0; i<n; i++) {
            long value = 1L * (leftMax[i] - nums[i]) * rightMax[i];
            result = Math.max(result, value);
        }
        return result;
    }
}