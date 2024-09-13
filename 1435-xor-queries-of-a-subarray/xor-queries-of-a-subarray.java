class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int idx = 0;

        for(int[] query: queries) {
            int left = query[0];
            int right = query[1];

            for(int i=left; i <=right; i++) {
                result[idx] ^= arr[i];
            }
            idx++;
        }
        return result;
    }
}