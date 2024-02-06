class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public static void mergeSort(int nums[], int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end-start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int nums[], int start, int mid, int end) {
        int l = start;
        int r = mid + 1;
        int t = 0;

        int temp[] = new int[end-start+1];

        while(l <= mid && r <= end) {
            if(nums[l] < nums[r]) {
                temp[t++] = nums[l++];
            }
            else{
                temp[t++] = nums[r++];
            }
        }

        while(l <= mid) {
            temp[t++] = nums[l++];
        }

        while(r <= end) {
            temp[t++] = nums[r++];
        }

        int j = start;
        for(int i=0; i<temp.length; i++) {
            nums[j] = temp[i];
            j++;
        }
    }
}