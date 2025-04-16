class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        long pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;

        while(j < n) {
            pairs += map.getOrDefault(nums[j], 0);
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(pairs >= k) {
                result += (n - j);
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                pairs -= map.get(nums[i]);
                i++;
            }
            j++;
        }

        return result;
    }
}