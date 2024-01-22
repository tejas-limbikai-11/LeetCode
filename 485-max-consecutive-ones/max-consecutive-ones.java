class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 1) count++;
            else{
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return Math.max(maxCount,count);
    }
}