class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long maxSum = 0;
        int count = 0;
        for(int i=n-1; i>=0 && count<k; i--) {
            maxSum += Math.max(happiness[i] - count, 0);
            count++;
        }
        return maxSum;
    }
}