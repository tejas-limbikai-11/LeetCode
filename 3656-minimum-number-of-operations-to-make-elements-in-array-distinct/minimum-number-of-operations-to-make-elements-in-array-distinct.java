class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i=n-1; i>=0; i--) {
            if(set.contains(nums[i])) break;
            else set.add(nums[i]);
        }

        int count = 0;
        while(n > set.size()) {
            count++;
            n -= 3;
        }
        return count;
    }
}