class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zero1 = 0;
        long sum2 = 0;
        int zero2 = 0;

        for(int num: nums1) {
            sum1 += num;
            if(num == 0) zero1++;
        }

        for(int num: nums2) {
            sum2 += num;
            if(num == 0) zero2++;
        }

        if(zero1 == 0 && sum1 < sum2 + zero2) return -1;
        if(zero2 == 0 && sum2 < sum1 + zero1) return -1;

        long minSum1 = sum1 + zero1;
        long minSum2 = sum2 + zero2;

        return Math.max(minSum1, minSum2);
    }
}