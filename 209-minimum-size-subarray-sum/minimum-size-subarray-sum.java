class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0, j=0;
        int sum = 0;
        int minLength = n+1;

        while(j < n) {
            sum += nums[j];

            while(sum >= target) {
                minLength = Math.min(minLength, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLength == n+1 ? 0 : minLength;
    }
}