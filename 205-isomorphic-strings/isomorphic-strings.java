class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for(Integer i=0; i<s.length(); i++) {
            if(mapS.put(s.charAt(i), i) != mapT.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}