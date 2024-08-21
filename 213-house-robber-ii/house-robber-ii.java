class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int prevPrev = 0;
        int prev = 0;

        for(int i=1; i<n; i++) {
            int rob = nums[i-1] + ((i >= 2) ? prevPrev : 0);
            int skip = prev;
            int temp = Math.max(rob, skip);
            prevPrev = prev;
            prev = temp;
        }
        int FirstHouseRobbed = prev;

        prevPrev = 0;
        prev = 0;

        for(int i=2; i<=n; i++) {
            int rob = nums[i-1] + prevPrev;
            int skip = prev;
            int temp = Math.max(rob, skip);
            prevPrev = prev;
            prev = temp;
        }
        int FirstHouseNotRobbed = prev;

        return Math.max(FirstHouseRobbed, FirstHouseNotRobbed);
    }
    
}
