class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            int target = 2 * arr[i];
            int l = 0;
            int r = arr.length - 1;

            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(arr[mid] == target && mid != i) return true;
                if(arr[mid] < target) l = mid+1;
                else r = mid-1;
            }
        }
        return false;
    }
}