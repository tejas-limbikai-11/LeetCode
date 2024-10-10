class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalindrome(s, i, j)) {
                    if(j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public boolean isPalindrome(String s, int i, int j) {
        if(i >= j) return true;

        if(s.charAt(i) == s.charAt(j)) {
            return isPalindrome(s, i + 1, j - 1);
        }
        else return false;
    }
}