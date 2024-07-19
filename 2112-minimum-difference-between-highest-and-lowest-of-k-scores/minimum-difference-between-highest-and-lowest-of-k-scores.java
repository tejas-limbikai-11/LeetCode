class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = k - 1;
        int minDiff = Integer.MAX_VALUE;

        while(j < nums.length) {
            minDiff = Math.min(minDiff, nums[j] - nums[i]);
            i++;
            j++;
        }
        return minDiff;
    }
}