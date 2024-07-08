class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while(i >= 0 || j >= 0) {
            i = getNextValidCharIndex(s, i);
            j = getNextValidCharIndex(t, j);

            // reached the end of both strings hence s and t are equal
            if(i < 0 && j < 0) return true;

            // reached the end of one of the strings hence s and t cannot be equal
            if(i < 0 || j < 0) return false;

            if(s.charAt(i) != t.charAt(j)) return false;

            i--;
            j--;
        }
        return true;
    }

    public int getNextValidCharIndex(String str, int end) {
        int backspaceCount = 0;
        while(end >= 0) {
            if(str.charAt(end) == '#') backspaceCount++;
            else if(backspaceCount > 0) backspaceCount--;
            else break;
            end--;
        }
        return end;
    }
}