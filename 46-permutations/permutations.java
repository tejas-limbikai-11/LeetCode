class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        solve(nums, temp, result, set);
        return result;
    }

    public void solve(int[] nums, List<Integer> temp, List<List<Integer>> result, Set<Integer> set) {
        int n = nums.length;
        if(temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!set.contains(nums[i])) {
                temp.add(nums[i]);
                set.add(nums[i]);
                solve(nums, temp, result, set);
                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}