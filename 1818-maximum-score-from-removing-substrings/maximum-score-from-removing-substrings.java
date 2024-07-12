class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        int countA = 0;
        int countB = 0;
        int minScore = Math.min(x, y);

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == 'a') {
                if(x < y && countB > 0) {
                    score += y;
                    countB--;
                } 
                else countA++;
            }
            else if(ch == 'b') {
                if(x > y && countA > 0) {
                    score += x;
                    countA--;
                }
                else countB++;
            }
            else{
                score += Math.min(countA, countB) * minScore;
                countA = 0;
                countB = 0;
            } 
        }
        score += Math.min(countA, countB) * minScore;

        return score;
    }
}