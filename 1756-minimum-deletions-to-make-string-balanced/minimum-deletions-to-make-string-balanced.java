class Solution {
    public int minimumDeletions(String s) {
        int countA = 0;
        int countB = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'b') countB++;
            else if(countB > countA) countA++;
        }
        return countA;
    }
}