class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;

        Arrays.sort(nums);
        int left = 0, right = n - 4;
        int ans = Integer.MAX_VALUE;

        while(right < n) {
            ans = Math.min(ans, nums[right] - nums[left]);
            left++;
            right++;
        }

        return ans;
    }
}