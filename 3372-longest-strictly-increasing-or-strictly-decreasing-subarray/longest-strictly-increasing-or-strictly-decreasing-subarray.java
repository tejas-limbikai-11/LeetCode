class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1, incLength = 1, decLength = 1;

        for(int i=1; i<n; i++) {
            if(nums[i] > nums[i-1]) {
                incLength++;
                decLength = 1;
            }
            else if(nums[i] < nums[i-1]) {
                decLength++;
                incLength = 1;
            }
            else {
                decLength = 1;
                incLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }
}
