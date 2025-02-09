class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }

        for (int i = 0; i < n; i++) {
            count += i - map.getOrDefault(arr[i], 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}