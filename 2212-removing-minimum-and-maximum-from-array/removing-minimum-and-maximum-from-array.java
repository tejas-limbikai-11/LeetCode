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

        int removeFront = Math.max(minIdx, maxIdx) + 1;
        int removeBack = n- Math.min(minIdx, maxIdx);
        int removeSeparate = (Math.min(minIdx, maxIdx) + 1) + (n - Math.max(minIdx, maxIdx));
        
        return Math.min(removeSeparate, Math.min(removeFront, removeBack));
    }
}