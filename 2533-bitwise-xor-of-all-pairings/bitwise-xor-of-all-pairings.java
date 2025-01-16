class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int result = 0;

        if(n % 2 != 0) {
            for(int i=0; i<m; i++) {
                result ^= nums2[i];
            }
        }

        if(m % 2 != 0) {
            for(int i=0; i<n; i++) {
                result ^= nums1[i];
            }
        }

        return result;
    }
}