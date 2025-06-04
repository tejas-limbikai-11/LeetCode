class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1) return word;

        int i = bestStartingPoint(word, n);

        int longestPossible = n - (numFriends - 1);
        int canTakeLength = Math.min(longestPossible, n - i);

        return word.substring(i, i + canTakeLength);
    }

    public int bestStartingPoint(String word, int n) {
        int i = 0;
        int j = 1;

        while(j < n) {
            int k = 0;

            while(j + k < n && word.charAt(i + k) == word.charAt(j + k)) {
                k++;
            }

            if(j + k < n && word.charAt(j + k) > word.charAt(i + k)) {
                i = j;
                j = j + 1;
            }
            else j = j + k + 1;
        }

        return i;
    }
}