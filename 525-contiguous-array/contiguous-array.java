class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        
        map.put(0, -1);

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) sum += -1;
            else sum += nums[i];

            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            else map.put(sum, i);
        }
        return maxLength;
    }
}