class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int expected = (m + n) * mean;
        int gap = expected - sum;
        int[] result = new int[n];

        if((gap > 6 * n) || (gap < 1 * n) || expected <= sum) {
            return new int[] {};
        }

        int rem = gap % n;
        int div = gap / n;
        for(int i=0; i<n; i++) {
            result[i] = div;
        }
        int i = 0;
        while(rem-- > 0) {
            result[i++] += 1;
        }
        return result;
    }
}