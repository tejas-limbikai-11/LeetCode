class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int count = 0;
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == max) {
                count++;
            }
            else count = 0;
            result = Math.max(result, count);
        }
        return result;
    }
}