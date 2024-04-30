class Solution {
    public int maxPower(String s) {
        int power = 1;
        char ch = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            if(ch == s.charAt(i)) {
                count++;
                power = Math.max(power, count);
            } else {
                ch = s.charAt(i);
                count = 1;
            }
        }
        return power;
    }
}