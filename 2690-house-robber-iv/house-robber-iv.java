class Solution {
    public int minCapability(int[] nums, int k) {
       int n = nums.length;

       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;

       for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
       }

       int l = min, r = max;
       int result = 0;

       while (l <= r) {
            int mid = l + (r - l) / 2;
            if(isPossible(nums, k, mid)) {
                r = mid - 1;
                result = mid;
            }
            else l = mid + 1;
       }
       return result;
    }

    public boolean isPossible(int[] nums, int k, int mid) {
        int count = 0;
        int i = 0;

        while(i < nums.length) {
            if(nums[i] <= mid) {
                count++;
                i++;
            }
            i++;
        }
        return count >= k;
    }
}