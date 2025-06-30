class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            int min = nums[i];
            int max = nums[i] + 1;
            if(map.containsKey(max)) {
                int temp = map.get(min) + map.getOrDefault(max, 0);
                result = Math.max(result, temp);
            }
        }

        return result;
    }
}