class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        int[] result = new int[n];
        if(k == 0) return result;

        int i = -1;
        int j = -1;

        if(k > 0) {
            i = 1;
            j = k;
        }
        else if(k < 0) {
            i = n - Math.abs(k);
            j = n - 1;
        }

        int windowSum = 0;
        for(int x=i; x<=j; x++) {
            windowSum += code[x];
        }

        for(int x=0; x<n; x++) {
            result[x] = windowSum;

            windowSum -= code[i % n];
            i++;

            windowSum += code[(j + 1) % n];
            j++;
        }

        return result;
    }
}