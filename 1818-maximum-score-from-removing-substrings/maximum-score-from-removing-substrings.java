class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;

        String maxStr = (x > y) ? "ab" : "ba";
        String minStr = (x < y) ? "ab" : "ba";
        int maxScore = Math.max(x, y);
        int minScore = Math.min(x, y);

        String tempFirst = removeSubstring(s, maxStr);
        int removedPairsCount = (s.length() - tempFirst.length()) / 2;
        score += removedPairsCount * maxScore;

        String tempSecond = removeSubstring(tempFirst, minStr);
        removedPairsCount = (tempFirst.length() - tempSecond.length())/2;
        score += removedPairsCount * minScore;

        return score;
    }

    public String removeSubstring(String inputStr, String matchStr) {
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for(int i=0; i<inputStr.length(); i++) {
            sb.append(inputStr.charAt(i));
            j++;

            if(j >= 2 && sb.charAt(j - 2) == matchStr.charAt(0) && sb.charAt(j - 1) == matchStr.charAt(1)) {
                sb.delete(j-2, j);
                j -= 2;
            }
        }

        return sb.toString();
    }
}