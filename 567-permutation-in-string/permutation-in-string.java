class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(m < n) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        for(char ch: s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> s2Map = new HashMap<>();

        int i = 0;
        int j = n;

        for(int k=i; k<j; k++) {
            char ch = s2.charAt(k);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
        }
        if(s1Map.equals(s2Map)) return true;

        while(j < m) {
            s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i)) - 1);
            if(s2Map.get(s2.charAt(i)) == 0) s2Map.remove(s2.charAt(i));

            s2Map.put(s2.charAt(j), s2Map.getOrDefault(s2.charAt(j), 0) + 1);

            if(s1Map.equals(s2Map)) return true;

            i++;
            j++;
        }
        return false;
    }
}