class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int result = 0;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canEatInTime(mid, piles, h)) {
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }

    public boolean canEatInTime(int k, int piles[], int h) {
        int hours = 0;
        for(int pile: piles) {
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}