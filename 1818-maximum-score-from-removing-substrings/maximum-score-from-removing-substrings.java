class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;

        String maxStr = (x > y) ? "ab" : "ba";
        String minStr = (x < y) ? "ab" : "ba";
        int maxScore = Math.max(x, y);
        int minScore = Math.min(x, y);

        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            sb.append(ch);
            if(sb.length() >= 2 && sb.substring(sb.length()-2).equals(maxStr)) {
                sb.setLength(sb.length()-2); //remove last 2 chars
                score += maxScore;
            }
        }

        String newStr = sb.toString();
        sb.setLength(0);
        for(char ch: newStr.toCharArray()) {
            sb.append(ch);
            if(sb.length() >= 2 && sb.substring(sb.length()-2).equals(minStr)) {
                sb.setLength(sb.length()-2); 
                score += minScore;
            }
        }

        return score;
    }
}