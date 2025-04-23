class Solution {
    public int countLargestGroup(int n) {
        int count = 0;
        int sums[] = new int[37];
        int maxI = 0;

        for(int i=1; i<=n; i++) {
            sums[sumOfDigits(i)]++;
        }

        for(int i: sums) {
            if(i > maxI) {
                maxI = i;
                count = 1;
            }
            else if(i == maxI) count++;
        }

        return count;
    }

    public int sumOfDigits(int num) {
        int sum = 0;

        while(num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}