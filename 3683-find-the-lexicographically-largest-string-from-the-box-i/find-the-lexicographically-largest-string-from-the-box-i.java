class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1) return word;

        int longestPossible = n - (numFriends - 1);
        String result = "";

        for(int i=0; i<n; i++) {
            int canTakeLength = Math.min(longestPossible, n - i);
            String subStr = word.substring(i, i + canTakeLength);
            if(subStr.compareTo(result) > 0) {
                result = subStr;
            }
        }
        return result;
    }
}