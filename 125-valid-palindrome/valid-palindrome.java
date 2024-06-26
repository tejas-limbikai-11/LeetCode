class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder b = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                b.append(s.charAt(i));
            }
        }
        return recursive(b, 0, b.length());
    }

    public boolean recursive(StringBuilder b, int i, int n) {
        if(i >= n/2) return true;
        if(b.charAt(i) != b.charAt(n-i-1)) return false;
        return recursive(b, i+1, n);
    }
}