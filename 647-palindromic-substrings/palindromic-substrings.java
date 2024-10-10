class Solution {
    private int count = 0;

    public int countSubstrings(String s) {
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            isPalindrome(i, i, s, n);
            isPalindrome(i, i+1, s, n);
        }
        return count;
    }

    public void isPalindrome(int i, int j, String s, int n) {
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}