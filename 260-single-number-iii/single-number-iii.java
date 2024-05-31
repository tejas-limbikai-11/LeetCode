class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;
        for(int num: nums) xor ^= num;
        long mask = xor & (-xor);

        int groupa = 0;
        int groupb = 0;

        for(int num: nums) {
            if((num & mask) != 0) groupa ^= num;
            else groupb ^= num;
        }   

        return new int[]{groupa, groupb};
    }
}