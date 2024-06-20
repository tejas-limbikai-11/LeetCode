class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        Arrays.sort(quantities);
        int left = 1;
        int right = quantities[m-1];

        int result = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isValid(mid, n, quantities)) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }

    public boolean isValid(int mid, int n, int quantities[]) {
        int count = 0;
        for(int quantity: quantities) {
            count += (mid + quantity - 1) / mid;
            if(count > n) return false;
        }
        return true;
    }
}