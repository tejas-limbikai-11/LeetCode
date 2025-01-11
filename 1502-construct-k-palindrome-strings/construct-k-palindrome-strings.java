class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26]; 

        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        if(s.length() < k) return false;

        int oddFreq = 0;
        for(int f: freq) {
            if(f % 2 == 1) oddFreq++;
        }

        if(oddFreq > k) return false;

        return true;
    }
}