class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int num: nums) {
            max = Math.max(max, num);
        }

        int l = 1, r = max;
        int result = 0;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(isPossible(nums, maxOperations, mid)) {
                result = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return result;
    }

    public boolean isPossible(int[] nums, int maxOperations, int mid) {
        int totalOperations = 0;

        for(int num: nums) {
            int operations = num / mid;
            if(num % mid == 0) operations--;
            totalOperations += operations;
        }

        if(totalOperations > maxOperations) return false;
        return true;
    }
}