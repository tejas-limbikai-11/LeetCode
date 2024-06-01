class Solution {
    public int scoreOfString(String s) {
       int i = 0;
       int j = 1;
       int diff = 0;

       while(j < s.length()) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            diff += Math.abs(ch2 - ch1);
            i++;
            j++;
       } 
       return diff;
    }
}