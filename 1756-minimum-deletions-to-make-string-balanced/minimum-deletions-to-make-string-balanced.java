class Solution {
    public int minimumDeletions(String s) {
        int dp = 0;     // count the extra 'a'
        int countB = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'b') countB++;

            else dp = Math.min(dp + 1, countB);     // 1. delete 'a' // 2. keep curr 'a', delete all 'b'         
        }
        return dp;
    }
}