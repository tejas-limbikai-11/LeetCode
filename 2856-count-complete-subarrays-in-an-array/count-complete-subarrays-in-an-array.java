class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0, j = 0;
        Map<Integer, Integer> currMap = new HashMap<>();

        while(i < n) {
            while(j < n && currMap.size() < map.size()) {
                currMap.put(nums[j], currMap.getOrDefault(nums[j], 0) + 1);
                j++;
            }

            if(map.size() == currMap.size()) {
                count += n - j + 1;
            }

            currMap.put(nums[i], currMap.get(nums[i]) - 1);
            if(currMap.get(nums[i]) == 0) {
                currMap.remove(nums[i]);
            }

            i++;
        }
        return count;
    }
}