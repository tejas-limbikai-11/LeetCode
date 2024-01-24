class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int i=0;
        while(i<nums.length){
            for(int j=0; j<nums.length; j++){
                if(i!= j && nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j; 
                }
            }
            i++;
        }
        return ans;
    }
}