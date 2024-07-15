class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            ans[i] = nextGreatElement(nums1[i], nums2);
        }
        return ans;
    }

    public int nextGreatElement(int num, int[] arr) {
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            if(num == arr[i]) {
                idx = i;
                break;
            }
        }
        while(idx < arr.length) {
            if(arr[idx] > num) return arr[idx];
            idx++;
        }
        return -1;
    }
}