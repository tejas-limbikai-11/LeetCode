class Solution {
    public boolean isAnagram(String s, String t) {
        int Frequency[] = new int[26];

        // Frequency of characters in String s (increment frequency array)
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            Frequency[ch - 'a']++;
        }

        // Frequency of characters in String t (decrement frequency array)
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            Frequency[ch - 'a']--;
        }

        //comparison (check if every element is 0)
        for(int i=0; i<26; i++){
            if(Frequency[i] != 0)return false;
        }
        return true;
    }
}