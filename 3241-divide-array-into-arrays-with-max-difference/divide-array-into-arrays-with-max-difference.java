class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int m = n / 3;
        int[][] result = new int[m][3];
        Arrays.sort(nums);

        int j = 0;
        for(int i=0; i<n-2; i+=3) {
            if(nums[i+2] - nums[i] > k) return new int[][]{};
            result[j][0] = nums[i];
            result[j][1] = nums[i+1];
            result[j][2] = nums[i+2];
            j++;
        }

        return result;
    }
}