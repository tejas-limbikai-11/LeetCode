class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int product = 1;
        
        if(k <= 1) return 0;
 
        while(right < nums.length) {
            product *= nums[right];

            while(product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left +1);
            right++;
        }

        return count;
    }
}