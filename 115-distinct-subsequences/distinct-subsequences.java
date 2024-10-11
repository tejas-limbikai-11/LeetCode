class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        prev[0] = 1;
        curr[0] = 1;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    int take = prev[j-1];
                    int skip = prev[j];
                    curr[j] = take + skip;
                }
                else curr[j] = prev[j];
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}