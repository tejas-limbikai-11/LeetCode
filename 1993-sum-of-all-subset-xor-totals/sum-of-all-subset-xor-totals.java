class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        solve(nums, 0, currSubset, subsets);

        int result = 0;
        for(List<Integer> subset: subsets) {
            int xor = 0;
            for(int n: subset) {
                xor ^= n;
            }
            result += xor;
        }
        return result;
    }

    public void solve(int nums[], int idx, List<Integer> currSubset, List<List<Integer>> subsets) {
        if(idx >= nums.length) {
            subsets.add(new ArrayList<>(currSubset));
            return;
        }
        currSubset.add(nums[idx]);
        solve(nums, idx+1, currSubset, subsets);
        currSubset.remove(currSubset.size()-1);
        solve(nums, idx+1, currSubset, subsets);
    }
}