class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 1;
        int right = position[n-1] - position[0];
        int result = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(possibleToPlace(mid, position, m)) {
                result = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return result;
    }

    public boolean possibleToPlace(int mid, int position[], int m) {
        int prev = position[0];
        int countBalls = 1;

        for(int i=1; i<position.length; i++) {
            int curr = position[i];
            if(curr - prev >= mid) {
                countBalls++;
                prev = curr;
            }
            if(countBalls == m) break;
        }
        return countBalls == m;
    }
}