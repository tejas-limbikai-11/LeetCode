class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int lNear = 0;
        int lFar = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k) {
                map.put(nums[lNear], map.get(nums[lNear]) - 1);
                if(map.get(nums[lNear]) == 0) {
                    map.remove(nums[lNear]);
                }
                lNear++;
                lFar = lNear;
            }

            while(map.containsKey(nums[lNear]) && map.get(nums[lNear]) > 1) {
                map.put(nums[lNear], map.get(nums[lNear]) - 1);
                lNear++;
            }

            if(map.size() == k) {
                ans += lNear - lFar + 1;
            }
        }
        return ans;
    }
}