class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for(char ch: s.toCharArray()) {
            if(!set.contains(ch)) set.add(ch);
            else {
                set.remove(ch);
                length += 2;
            }
        }
        if(set.isEmpty()) return length;
        else return length + 1;
    }
}