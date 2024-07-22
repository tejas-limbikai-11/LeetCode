class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        int leftover = 0;

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()) {
            if(map.get(key) % 2 == 0) {
                pairs += map.get(key) / 2;
            }
            else {
                pairs += map.get(key) / 2;
                leftover++;
            }
        }

        int ans[] = new int[2];
        ans[0] = pairs;
        ans[1] = leftover;
        return ans;
    }
}