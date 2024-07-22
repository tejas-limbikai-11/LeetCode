class Solution {
    public int percentageLetter(String s, char letter) {
        int freq[] = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }
        double frequency = freq[letter - 'a'];
        return (int) (frequency / s.length() * 100);
    }
}