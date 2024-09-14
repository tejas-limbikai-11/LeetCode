class Solution {
    public int maxPossibleScore(int[] start, int d) {
        int n = start.length;
        Arrays.sort(start);
        long left = 0;
        long right = (long) 1e12;
        long result = 0;

        while(left <= right) {
            long mid = left + (right - left) / 2;
            long p = start[0];
            boolean isValid = true;

            for(int i=1; i<n; i++) {
                if((p + mid) >= start[i] && (p + mid) <= start[i] + d) {
                    p += mid;
                }
                else if((p + mid) < start[i]) {
                    p = start[i];
                }
                else {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                result = mid;
                left = mid + 1;
            } 
            else right = mid - 1;
        }
        return (int) result;
    }
}