class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=n-2; i>=1; i--) {
            for(int j=i+1; j<n; j++) {
                int num = nums[j] - nums[i];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(int j=0; j<i-1; j++) {
                int num = nums[j] + nums[i-1];
                count += map.getOrDefault(num, 0);
            }
        }
        return count;
    }
}