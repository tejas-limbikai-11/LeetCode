class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 != 0) return false;

        int openBrackets = 0;
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            char lock = locked.charAt(i);

            if(lock == '0' || ch == '(') openBrackets++;
            else openBrackets--;

            if(openBrackets < 0) return false;
        }

        int closeBrackets = 0;
        for(int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);
            char lock = locked.charAt(i);

            if(lock == '0' || ch == ')') closeBrackets++;
            else closeBrackets--;

            if(closeBrackets < 0) return false;
        }
        return true;
    }
}