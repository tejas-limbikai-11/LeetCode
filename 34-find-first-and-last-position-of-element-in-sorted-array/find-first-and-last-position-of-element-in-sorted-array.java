class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        if(lb == n || nums[lb] != target) return new int[]{-1, -1};
        return new int[]{lb, ub - 1};
    }

    public int lowerBound(int arr[], int x)
    {
        int left = 0;
        int right = arr.length-1;
        int ans = arr.length;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x) {
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }

    public int upperBound(int arr[], int x)
    {
        int left = 0;
        int right = arr.length-1;
        int ans = arr.length;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > x) {
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }
}