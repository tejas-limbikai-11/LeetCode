class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        
        while (i < word.length()) {
            char ch = word.charAt(i);
            int count = 0;

            while (i < word.length() && word.charAt(i) == ch && count < 9) {
                count++;
                i++;
            }
            
            comp.append(count).append(ch);
        }
        
        return comp.toString();
    }
}
