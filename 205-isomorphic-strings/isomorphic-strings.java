class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!mapST.containsKey(sChar)) {
                mapST.put(sChar, tChar);
            }
            if(!mapTS.containsKey(tChar)) {
                mapTS.put(tChar, sChar);
            }

            if(mapST.get(sChar) != tChar || mapTS.get(tChar) != sChar) {
                return false;
            }
        }
        return true;
    }
}