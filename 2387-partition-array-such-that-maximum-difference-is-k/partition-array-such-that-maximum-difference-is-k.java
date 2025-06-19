class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int count = 1;
        int i = 0;
        int j = 0;

        while(j < n) {
            if(nums[j] - nums[i] > k) {
                count++;
                i = j;
            }
            j++;
        }

        return count;
    }
}