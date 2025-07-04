class Solution {
    public char getNextCharacter(char ch) {
        if (ch == 'z') return 'a';
        return (char) (ch + 1);
    }

    public char kthCharacter(long k, int[] operations) {
        long[] stringSizes = new long[operations.length + 1];
        stringSizes[0] = 1;  

        for (int i = 0; i < operations.length; i++) {
            long newSize = 2 * stringSizes[i];
            stringSizes[i + 1] = Math.min(newSize, k);
        }

        char initialChar = 'a';  

        for (int i = operations.length - 1; i >= 0; i--) {
            if (k > stringSizes[i]) {
                k -= stringSizes[i];
                if (operations[i] == 1) {
                    initialChar = getNextCharacter(initialChar);
                }
            }
        }

        return initialChar;
    }
}
