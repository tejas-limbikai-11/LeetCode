class Solution {
    public int countSubarrays(int[] nums) {
        int i = 0;
        int j = 1;
        int k = 2;
        int count = 0;

        while(k < nums.length) {
            if((double) (nums[i] + nums[k]) == (double) nums[j] / 2) {
                count++;
            }
            i++;
            j++;
            k++;
        }
        return count;
    }
}