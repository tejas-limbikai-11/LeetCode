class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long result = 0;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    long value = 1L * (nums[i] - nums[j]) * nums[k];
                    result = Math.max(result, value);
                }
            }
        }
        return result;
    }
}