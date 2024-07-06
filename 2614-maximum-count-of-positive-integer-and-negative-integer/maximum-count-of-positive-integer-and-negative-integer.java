class Solution {
    public int maximumCount(int[] nums) {
        int pos = nums.length - firstPositive(nums);
        int neg = lastNegative(nums) + 1;
        return Math.max(pos, neg);
    }

    public int firstPositive(int[] nums) {
        int left = 0;
        int right = nums.length-1; 
        int ans = nums.length;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > 0) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int lastNegative(int[] nums) {
        int left = 0;
        int right = nums.length-1; 
        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < 0) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}