class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp, result);
        return result;
    }

    public void solve(int[] nums, int idx, List<Integer> temp, List<List<Integer>> result) {
        if(idx >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums, idx+1, temp, result);
        temp.remove(temp.size()-1);
        solve(nums, idx+1, temp, result);
    }
}