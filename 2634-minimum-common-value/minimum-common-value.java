class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if(nums2[0] > nums1[nums1.length-1]) return -1;

        int i=0, j=0;

        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]) return nums1[i];
            else if(nums2[j] > nums1[i]) i++;
            else j++;
        }
        return -1;
    }
}