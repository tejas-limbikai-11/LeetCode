class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sumOfDigits = 0;
        if(x < 10) sumOfDigits = x;
        else if(x == 100) sumOfDigits = 1;
        else sumOfDigits = x / 10 + x % 10;

        if(x % sumOfDigits == 0) return sumOfDigits;
        else return -1;
    }
}