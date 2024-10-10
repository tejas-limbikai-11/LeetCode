class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];

        for(int i=0; i<n; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (i, j) -> Integer.compare(nums[i], nums[j]));

        int min = n;
        int result = 0;

        for(int i=0; i<n; i++) {
            result = Math.max(result, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return result;
    }
}