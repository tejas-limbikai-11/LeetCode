class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int result = 0;

        for(int i=0; i<n; i++) {
            int bitMask = 0;
            for(int j=i; j<n; j++) {
                if((nums[j] & bitMask) != 0) break;
                bitMask |= nums[j];
                result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }
}