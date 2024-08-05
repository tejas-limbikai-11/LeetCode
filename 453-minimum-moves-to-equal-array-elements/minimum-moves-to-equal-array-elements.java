class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
        }

        int diff = 0;
        for(int num: nums) {
            diff += num - min;
        }
        return diff;
    }
}