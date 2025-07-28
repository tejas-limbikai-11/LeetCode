public class Solution {
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int i : nums)
            max = max | i;
        backtrack(nums, 0, max, 0);
        return count;
    }

    private void backtrack(int[] nums, int first, int max, int curr) {
        if (max == curr)
            count++;
        if (first >= nums.length)
            return;

        for (int i = first; i < nums.length; i++) {
            backtrack(nums, i + 1, max, curr | nums[i]);
        }
    }
}