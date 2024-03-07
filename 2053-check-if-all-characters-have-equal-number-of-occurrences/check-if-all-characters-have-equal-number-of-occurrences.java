class Solution {
    public boolean areOccurrencesEqual(String s) {
        int freq[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int frequency = freq[s.charAt(0) - 'a'];

        int i=0;
        while(i<freq.length) {
            if(freq[i] != 0) {
                if(frequency != freq[i]) return false;
            }
            i++;
        }

        return true;
    }
}