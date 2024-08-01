class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        boolean[] taken = new boolean[26];
        StringBuilder result = new StringBuilder();

        for(int i=0; i<n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(taken[ch - 'a']) continue;

            while(result.length() > 0 && result.charAt(result.length() - 1) > ch 
            && lastIndex[result.charAt(result.length() - 1) - 'a'] > i) {
                
                taken[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(ch);
            taken[ch - 'a'] = true;
        }
        
        return result.toString();
    }
}