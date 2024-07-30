class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, result);
        return result;
    }

    public void solve(int idx, int[] nums, List<List<Integer>> result) {
        int n = nums.length;
        if(idx == n) {
            List<Integer> temp = new ArrayList<>();
            for(int num: nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for(int i = idx; i < n; i++) {
            swap(nums, i, idx);
            solve(idx + 1, nums, result);
            swap(nums, i, idx);
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}