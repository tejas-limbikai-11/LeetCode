class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int culpritIdx = -1;
        int minKIdx = -1;
        int maxKIdx = -1;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) culpritIdx = i;
            if(nums[i] == minK) minKIdx = i;
            if(nums[i] == maxK) maxKIdx = i;

            long smallerIdx = Math.min(minKIdx, maxKIdx);
            long temp = smallerIdx - culpritIdx;
            ans += (temp <= 0) ? 0 : temp;
        }
        return ans;
    }
}