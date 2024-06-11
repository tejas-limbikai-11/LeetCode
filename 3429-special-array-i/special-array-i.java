class Solution {
    public boolean isArraySpecial(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if(parity(nums[i]) == parity(nums[i-1])) {
                return false;
            }
        }
        return true;
    }

    public int parity(int num) {
        if(num % 2 == 0) return 1;
        else return 0;
    }
}