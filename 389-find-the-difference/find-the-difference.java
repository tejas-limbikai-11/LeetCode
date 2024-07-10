class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch: s.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        for (Character ch: map.keySet()) {
            if(map.get(ch) == 1) {
                return ch;
            }
        }
        return 'a';
    }
}