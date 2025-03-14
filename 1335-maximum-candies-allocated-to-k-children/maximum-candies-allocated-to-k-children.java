class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        int maxC = 0;
        long totalC = 0;

        for(int candy: candies) {
            maxC = Math.max(maxC, candy);
            totalC += candy;
        }

        if(totalC < k) return 0;

        int l = 1, r = maxC;
        int result = 0;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            long count = 0;
            for(int i=0; i<n; i++) {
                count += candies[i] / mid;
            }
            if(count >= k) {
                l = mid + 1;
                result = mid;
            }
            else r = mid - 1;
        }
        return result;
    }
}