class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int countA = 0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'a') countA++;
        }

        int count = Integer.MAX_VALUE;
        int countB = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'a') countA--;

            count = Math.min(count, countA + countB);

            if(s.charAt(i) == 'b') countB++;
        }
        return count;
    }
}