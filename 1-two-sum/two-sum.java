class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int j=1;
        while(j<nums.length){
            for(int i=0; i+j<nums.length; i++){
                if(nums[i] + nums[i+j] == target){
                    ans[0] = i;
                    ans[1] = i+j; 
                    return ans;
                }
            }
            j++;
        }
        return ans;
    }
}