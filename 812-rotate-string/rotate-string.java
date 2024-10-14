class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;
        String str = s + s;

        for(int i=0; i<=n; i++) {
            if(str.substring(i, i + n).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}