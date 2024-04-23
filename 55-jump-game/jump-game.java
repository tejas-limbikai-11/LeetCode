class Solution {
    public boolean canJump(int[] nums) {
        int jump = nums.length - 1;
        for(int i = jump - 1; i > -1; i--){
            if(i + nums[i] >= jump){
                jump = i;
            }
        }
        return jump == 0;
    }
}