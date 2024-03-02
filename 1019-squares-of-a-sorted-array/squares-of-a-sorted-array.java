class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            nums[i] = n*n;
        }
        Arrays.sort(nums);
        return nums;
    }
}