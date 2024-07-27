class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;

        while(i < n) {
            if(s.charAt(i) == 'X') {
                count++;
                i += 3;
            }
            else i++;
        }
        return count;
    }
}