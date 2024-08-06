class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int result = 0;
        int row = 1;

        int quotient = n / 8;
        int remainder = n % 8;

        while(quotient > 0) {
            result += 8 * row;
            quotient--;
            row++;
        }

        result += remainder * row;
        
        return result;
    }
}