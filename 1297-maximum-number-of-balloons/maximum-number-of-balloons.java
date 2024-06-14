class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for(char ch: text.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char ch: map.keySet()) {
            if(ch == 'l' || ch == 'o') {
                map.put(ch, map.get(ch)/2);
            }
            if(map.containsKey(ch)) {
                min = Math.min(min, map.get(ch));
            }
        }
        return min;
    }
}