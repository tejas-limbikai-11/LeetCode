class Solution {
    public int specialArray(int[] nums) {
        for(int i=0; i<=nums.length; i++) {
            if(i == findX(nums, i)) return i;       
        }
        return -1;
    }

    public int findX(int[] nums, int num) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= num) count++;
        }
        return count;
    }
}