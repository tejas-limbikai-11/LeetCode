class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int weight: weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int left = max;
        int right = sum;

        int result = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canLoad(mid, weights, days)) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }     

    public boolean canLoad(int mid, int weights[], int days) {
        int capacity = 0; 
        int count = 1;
        for(int weight: weights) {
            capacity += weight;
            if(capacity > mid) {
                count++;
                capacity = weight;
            }
        }
        return count <= days;
    }      
}