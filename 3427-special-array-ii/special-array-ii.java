class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int q = queries.length;
        boolean[] result = new boolean[q];
        int[] violations = new int[nums.length];
        int idx = 0;

        for(int i=1; i<nums.length; i++) {
            if(!parity(nums[i], nums[i-1])) {
                violations[i]++;
            }
            violations[i] += violations[i-1];
        }

        for(int[] query: queries) {
            int start = query[0];
            int end = query[1];

            boolean bool = true;
            if(violations[end] - violations[start] > 0) {
                bool = false;
            }
            result[idx++] = bool;
        }
        return result;
    }

    public boolean parity(int a, int b) {
        if((a + b) % 2 != 0) return true;
        else return false;
    }
}