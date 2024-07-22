class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        int count = 0;

        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
                count++;
            }
        }

        if(count == 2 && set1.equals(set2)) return true;
        else return false;
    }
}