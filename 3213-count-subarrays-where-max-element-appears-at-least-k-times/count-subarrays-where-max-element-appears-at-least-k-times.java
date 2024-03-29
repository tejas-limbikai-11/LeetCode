class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int countMax = 0;
        long result = 0;

        int maxElement = 0;
        for(int i: nums) maxElement = Math.max(maxElement, i);

        while(right < n) {
            if(nums[right] == maxElement) countMax++;

            while(countMax >= k) {
                result += n - right;
                if(nums[left] == maxElement) countMax--;
                left++;
            }
            right++;
        }
        return result;
    }
}