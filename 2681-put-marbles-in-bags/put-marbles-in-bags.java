class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairSum = new int[n-1];

        for(int i=0; i<n-1; i++) {
            pairSum[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(pairSum);
        long minScore = 0, maxScore = 0;

        for(int i=0; i<k-1; i++) {
            minScore += pairSum[i];
            maxScore += pairSum[(n - 1) - 1 - i];
        }
        return maxScore - minScore;
    }
}