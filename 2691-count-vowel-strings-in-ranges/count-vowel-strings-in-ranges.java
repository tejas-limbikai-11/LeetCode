class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        prefix[0] = (isStartEndWithVowel(words[0])) ? 1 : 0;

        for(int i=1; i<words.length; i++) {
            String str = words[i];
            if(isStartEndWithVowel(str)) {
                prefix[i] = 1 + prefix[i-1];
            }
            else prefix[i] = prefix[i-1];
        }

        int[] result = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            result[i] = prefix[r] - (l > 0 ? prefix[l-1] : 0);
        }

        return result;
    }

    public boolean isStartEndWithVowel(String str) {
        char start = str.charAt(0);
        char end = str.charAt(str.length() - 1);

        boolean isStart = false;
        boolean isEnd = false;

        if(start == 'a' || start == 'e' || start == 'i' || start == 'o' || start == 'u') {
            isStart = true;
        }

        if(end == 'a' || end == 'e' || end == 'i' || end == 'o' || end == 'u') {
            isEnd = true;
        }

        return isStart && isEnd;
    }
}
