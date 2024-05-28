class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i=0, j=0;
        int currCost = 0;
        int maxLength = 0;

        while(j < n) {
            currCost += Math.abs(s.charAt(j) - t.charAt(j));
            
            while(currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }
}