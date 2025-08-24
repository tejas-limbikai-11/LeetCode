class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int zeroCount = 0;
        int length = 0;

        while(r < n) {
            if(nums[r] == 0) zeroCount++;
            while(zeroCount > 1) {
                if(nums[l] == 0) {
                    zeroCount = 1;
                }
                l++;
            }
            length = Math.max(length, r - l + 1);
            r++;
        }

        return length - 1;
    }
}