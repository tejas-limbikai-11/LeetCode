class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int min = n;
        int result = 0;

        for(int i=0; i<n; i++) {
            result = Math.max(result, arr[i][1] - min);
            min = Math.min(min, arr[i][1]);
        }
        return result;
    }
}