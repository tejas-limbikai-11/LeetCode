class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        boolean found = search(nums, original);
        while(found) {
            original = 2 * original;
            found = search(nums, original); 
        }
        return original;
    }

    public boolean search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}