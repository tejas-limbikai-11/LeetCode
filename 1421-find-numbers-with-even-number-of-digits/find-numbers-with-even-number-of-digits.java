class Solution {
    public int findNumbers(int[] nums) {
         int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (even(nums[i])) {
                count++;
            }
        }
        return count;
    }

    boolean even(int num) {
        int numOfdigits = digits(num);
        if (numOfdigits % 2 == 0) {
            return true;
        }
        return false;
    }

    int digits(int num) {
        if (num < 0) {
            num = num * -1;
        }
        return (int) (Math.log10(num)) + 1;
    }
}