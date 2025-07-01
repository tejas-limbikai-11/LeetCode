class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int[] freq = new int[26];
        char prev = word.charAt(0);
        freq[prev - 'a'] = 1;

        int result = 1;
        for(int i=1; i<n; i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
            if(prev != ch) {
                result += freq[prev - 'a'] - 1;
                freq[prev - 'a'] = 0;
                prev = ch;
            }
        }

        for(int f: freq) {
            if(f > 0) {
                result += (f - 1);
            }
        }

        return result;
    }
}