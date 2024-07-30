class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] digitCount = new int[10];
        for(int digit: digits) {
            digitCount[digit]++;
        }
        List<Integer> evenNumbers = new ArrayList<>();

        for(int i = 100; i < 999; i += 2) {
            if(canBeFormed(i, digitCount)) {
                evenNumbers.add(i);
            }
        }
        int[] result = new int[evenNumbers.size()];
        for(int i=0; i<evenNumbers.size(); i++) {
            result[i] = evenNumbers.get(i);
        }
        return result;
    }

    public boolean canBeFormed(int num, int[] digitCount) {
        int[] numberDigits = new int[10];

        int mod = 0;
        while(num > 0) {
            mod = num % 10;
            numberDigits[mod]++;
            num /= 10;
        }
        for(int i=0; i<numberDigits.length; i++) {
            if(numberDigits[i] > digitCount[i]) {
                return false;
            }
        }
        return true;
    }
}