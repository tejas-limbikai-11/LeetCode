class Solution {
    public long minimumSteps(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        long count = 0;

        int ones = 0;
        int zeros = 0;

        for(int i=n-1; i>=0; i--) {
            if(arr[i] == '0') zeros++;
            if(arr[i] == '1') {
                count += zeros;
            }
        }
        return count;
    }
}