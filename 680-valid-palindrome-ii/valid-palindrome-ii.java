class Solution {
    public boolean validPalindrome(String s) {
        int count = 0;
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                String skipL = s.substring(i + 1, j + 1);
                String skipR = s.substring(i, j);
                return(isPalindrome(skipL) || isPalindrome(skipR));
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}