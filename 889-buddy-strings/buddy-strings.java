class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if(s.equals(goal)) {
            for(char key: map.keySet()) {
                if(map.get(key) > 1) return true;
            }
            return false;
        }

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        int count = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                set1.add(s.charAt(i));
                set2.add(goal.charAt(i));
                count++;
            }
        }

        if(count == 2 && set1.equals(set2)) return true;
        else return false;
    }
}