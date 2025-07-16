class Solution {
    public int maximumLength(int[] nums) {
        int result = 0;
        int even = 0;
        int odd = 0;
        int alternating = 1;
        int prev = -1;

        for(int num: nums) {
            if(num % 2 == 0) even++;
            else odd++;

            if(prev != -1 && num % 2 != prev % 2) {
                alternating++;
            }
            prev = num;
        }

        return Math.max(even, Math.max(odd, alternating));

    }
}