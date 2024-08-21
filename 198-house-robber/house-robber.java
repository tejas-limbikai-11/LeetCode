class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prevPrev = 0;
        int prev = nums[0];

        for(int i=2; i<=n; i++) {
            int rob = nums[i-1] + prevPrev;
            int skip = prev;

            int temp = Math.max(rob, skip);
            prevPrev = prev;
            prev = temp;
        }
        
        return prev;
    }
}