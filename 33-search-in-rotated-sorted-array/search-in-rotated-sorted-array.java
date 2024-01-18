class Solution {
    public int search(int[] nums, int target) {
        int min = minSearch(nums);

        //find in right (1, 2, 3)
        if(nums[min] <= target && target <= nums[nums.length-1]){
            return binarySearch(nums, min, nums.length-1, target);
        }
        //find in left(4, 5, 6, 7)
        else{
            return binarySearch(nums, 0, min, target);
        }
    }

    public static int binarySearch(int arr[], int left, int right, int target){
        int l = left;
        int r = right;
        
        while (l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    public static int minSearch(int arr[]){
        int left = 0;
        int right = arr.length-1;

        while (left<right) {
            int mid = left + (right - left) / 2;
            if(mid > 0 && arr[mid-1]>arr[mid]){
                return mid;
            }
            else if(arr[mid]>=arr[left] && arr[mid]>arr[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
}