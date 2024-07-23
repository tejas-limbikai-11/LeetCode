class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = 0;
        int max = 0;

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == key) {
                int num = nums[i+1];
                map.put(num, map.getOrDefault(num, 0) + 1);

                if(map.get(num) > max) {
                    max = Math.max(max, map.get(num));
                    target = num;
                }
            }
        }

        return target;
    }
}