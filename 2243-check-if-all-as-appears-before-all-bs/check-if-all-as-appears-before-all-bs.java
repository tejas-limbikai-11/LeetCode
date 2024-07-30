class Solution {
    public boolean checkString(String s) {
        int a = 0, b = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a') {
                a++;
                if(b > 0) return false;
            }
            else b++;
        }
        return true;
    }
}