class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xorArr = new int[n];
        xorArr[0] = arr[0];

        for(int i=1; i<n; i++) {
            xorArr[i] = xorArr[i-1] ^ arr[i];
        }

        int[] result = new int[queries.length];
        int idx = 0;
        for(int[] query: queries) {
            int left = query[0];
            int right = query[1];

            result[idx] = (left == 0 ? 0 : xorArr[left - 1]) ^ xorArr[right];
            idx++;
        }
        return result;
    }
}