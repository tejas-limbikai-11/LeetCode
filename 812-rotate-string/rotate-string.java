class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;
        String str = s + s;

        if(str.contains(goal)) return true;
        
        return false;
    }
}