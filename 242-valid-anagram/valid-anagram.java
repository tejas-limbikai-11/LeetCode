class Solution {
    public boolean isAnagram(String s, String t) {
        int sFrequency[] = new int[26];
        int tFrequency[] = new int[26];

        // Frequency of characters in String s
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            sFrequency[ch - 'a']++;
        }

        // Frequency of characters in String t
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            tFrequency[ch - 'a']++;
        }

        //comparison
        for(int i=0; i<26; i++){
            if(sFrequency[i] != tFrequency[i]){
                return false;
            }
        }

        return true;
    }
}