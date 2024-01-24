class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol  = new int[2];
        int j = 1;
        while (j<nums.length){
            for(int i=0; i+j<nums.length; i++){
                if(nums[i] + nums[i+j] == target){
                    sol[0] = i;
                    sol[1] = i+j;
                    return sol;
                }
            }
            j++;
        }
        return sol;
    }
}