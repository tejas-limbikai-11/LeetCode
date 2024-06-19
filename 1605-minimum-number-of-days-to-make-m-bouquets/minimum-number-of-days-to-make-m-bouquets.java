class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int maxValue = 0;
        for(int day: bloomDay) {
            maxValue = Math.max(maxValue, day);
        }

        int start = 0;
        int end = maxValue;
        int minDays = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } 
            else start = mid + 1;
        }
        return minDays;
    }

    public int getNumOfBouquets(int bloomDay[], int mid, int k) {
        int numOfBouquets = 0;
        int consecutiveCount = 0;

        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) consecutiveCount++;
            else consecutiveCount = 0;

            if(consecutiveCount == k) {
                numOfBouquets++;
                consecutiveCount = 0;
            }
        }
        return numOfBouquets;
    }
}