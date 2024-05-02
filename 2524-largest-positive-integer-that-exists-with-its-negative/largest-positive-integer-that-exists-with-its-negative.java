class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j) {
            if(-nums[i] == nums[j]) return nums[j];
            else if(-nums[i] < nums[j]) j--;
            else i++;
        }
        return -1;
    }
}