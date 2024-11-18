class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

       int[] result = new int[n];

        for(int i=0; i<n; i++) {
            int sum = 0;
            int count = 0;
            if(k > 0) {
                for(int j=i+1; j<i+n && count < k; j++) {
                    sum += code[j % n];
                    count++;
                }
                result[i] = sum;
            }
            else if(k < 0) {
                for(int j= i-1; j>i-n && count < Math.abs(k); j--) {
                    sum += code[(j + n) % n];
                    count++;
                }
                result[i] = sum;
            }
            else result[i] = 0;
        }

        return result;
    }
}