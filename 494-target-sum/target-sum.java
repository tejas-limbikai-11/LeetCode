class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, target, nums);
    }

    public int solve(int idx, int sum, int target, int[] nums) {
        if(idx >= nums.length) {
            if(sum == target) return 1;
            else return 0;
        }

        int negative = solve(idx + 1, sum - nums[idx], target, nums);
        int positive = solve(idx + 1, sum + nums[idx], target, nums);

        return negative + positive;
    }
}