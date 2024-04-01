class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) > 64 && s.charAt(i) < 123) {
                length++;
            }
            if(Character.isWhitespace(s.charAt(i)) && length > 0) {
                break;
            }
        }
        return length;
    }
}