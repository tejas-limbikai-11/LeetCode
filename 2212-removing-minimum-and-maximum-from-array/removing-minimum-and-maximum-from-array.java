class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if(nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int removeFront = (minIdx < maxIdx) ? maxIdx + 1 : minIdx + 1;
        int removeBack = (minIdx < maxIdx) ? n - minIdx : n - maxIdx;
        int removeSeparate = (minIdx < maxIdx) ? ((minIdx + 1) + (n - maxIdx)) : ((maxIdx + 1) + (n - minIdx));

        return Math.min(removeSeparate, Math.min(removeFront, removeBack));
    }
}