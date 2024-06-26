class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0; i<words.length; i++) {
            StringBuilder b = new StringBuilder(words[i]);
            if(isPalindrome(b, 0, b.length())) return words[i];
        }
        return "";
    }

    public boolean isPalindrome(StringBuilder b, int i, int n) {
        if(i >= n/2) return true;
        if(b.charAt(i) != b.charAt(n-i-1)) return false;
        return isPalindrome(b, i+1, n);
    }
}