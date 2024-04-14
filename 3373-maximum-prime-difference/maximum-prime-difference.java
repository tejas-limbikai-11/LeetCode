class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if(isPrime(nums[left]) && isPrime(nums[right])) return right - left;
            if(!isPrime(nums[left])) left++;
            if(!isPrime(nums[right])) right--;
        }
        return 0;
    }

    public boolean isPrime(int number) {
        if(number == 1) return false;
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}