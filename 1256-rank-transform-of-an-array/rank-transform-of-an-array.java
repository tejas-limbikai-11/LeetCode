class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[][] nums = new int[n][2];

        for(int i=0; i<n; i++) {
            nums[i][0] = arr[i];
            nums[i][1] = i;
        }

        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));

        int[] result = new int[n];

        int prev = -1;
        int rank = 0;

        for(int i=0; i<n; i++) {
            if(nums[i][0] != prev) {
                rank++;
            }
            prev = nums[i][0];
            result[nums[i][1]] = rank;
        }

        return result;
    }
}