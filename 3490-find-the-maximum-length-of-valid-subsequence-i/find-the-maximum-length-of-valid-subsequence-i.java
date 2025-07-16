class Solution {
    public int maximumLength(int[] nums) {
        int result = 0;
        int eveneven = 0;
        int oddodd = 0;
        int oddeven = 1;
        int prev = -1;

        for(int num: nums) {
            if(num % 2 == 0) eveneven++;
            else oddodd++;

            if(prev != -1 && num % 2 != prev % 2) {
                oddeven++;
            }
            prev = num;
        }

        return Math.max(eveneven, Math.max(oddodd, oddeven));

    }
}