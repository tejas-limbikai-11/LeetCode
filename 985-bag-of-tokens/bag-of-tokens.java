class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;

        while(left<=right) {
            if(tokens[left]<=power) {
                power = power - tokens[left];
                score++;
                left++;
            }
            else if(tokens[left]>power && score >= 1){
                if(left == right) break;
                power = power + tokens[right];
                score--;
                right--;
            } 
            else{
                break;
            }
        }
        return score;
    }
}