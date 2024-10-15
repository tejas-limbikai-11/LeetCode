class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];

        for(int idx = n-1; idx >= 0; idx--) {
            for(int prevIdx = idx-1; prevIdx >= -1; prevIdx--) {
                int take = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
                    take = 1 + next[idx + 1];
                }

                int skip = next[prevIdx + 1];

                curr[prevIdx + 1] = Math.max(take, skip);
            }
            next = curr.clone();
        }
        
        return next[-1 + 1];
    }
}