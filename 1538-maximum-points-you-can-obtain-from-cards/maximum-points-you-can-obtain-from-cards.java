class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;

        for(int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        int result = sum;

        for(int i = k-1; i >= 0; i--) {
            sum -= cardPoints[i];
            sum += cardPoints[n - k + i];
            result = Math.max(result, sum);
        }
        return result;
    }
}