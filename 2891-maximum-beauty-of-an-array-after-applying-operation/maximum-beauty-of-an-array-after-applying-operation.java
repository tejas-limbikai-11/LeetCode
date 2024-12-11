class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxBeauty = 0;
        int i = 0;
        int j = 0;

        while(i < n) {
            while(j < n && nums[j] <= nums[i] + 2 * k) {  //y <= x + 2 * k
                j++;
            }

            maxBeauty = Math.max(maxBeauty, j - i);
            i++;
        }
        return maxBeauty;
    }
}