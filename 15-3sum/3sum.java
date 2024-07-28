class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(n < 3) return result;
        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            twoSum(nums, target, i+1, n-1, result);
        }
        return result;
    }

    public void twoSum(int[] nums, int target, int i, int j, List<List<Integer>> result) {

        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum < target) {
                i++;
            } else if(sum > target) {
                j--;
            } else {
                while(i < j && nums[i] == nums[i+1]) i++;
                while(i < j && nums[j] == nums[j-1]) j--;

                result.add(Arrays.asList(-target, nums[i], nums[j]));
                i++;
                j--;
            }
        }
    }
}