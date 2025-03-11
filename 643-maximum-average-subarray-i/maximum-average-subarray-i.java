class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        double sum = 0;
        double average = Integer.MIN_VALUE;

        while (j < n) {
            sum += nums[j];

            if (j - i + 1 == k) {
                average = Math.max(average, sum / k);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return average;
    }
}