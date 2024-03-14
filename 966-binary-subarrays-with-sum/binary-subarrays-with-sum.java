class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(goal, nums) - helper(goal-1, nums);
    }

    // Count number of subarrays where count <= x
    public int helper(int x, int[] nums) {
        if(x < 0) return 0;
        int count = 0;
        int sum = 0;
        int left = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum > x) {
                sum -= nums[left];
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }   
}