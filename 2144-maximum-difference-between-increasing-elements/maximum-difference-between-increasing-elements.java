class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int result = -1;
        int min = nums[0];

        for(int i=1; i<n; i++) {
            if(nums[i] <= min) min = nums[i];
            else result = Math.max(result, nums[i] - min);
        }
        return result;
    }
}