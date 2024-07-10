class Solution {
    public char findTheDifference(String s, String t) {
        char tArray[] = t.toCharArray();
        for(int i=0; i<s.length(); i++) {
            tArray[i+1] += tArray[i] - s.charAt(i);
        }
        return tArray[t.length() - 1];
    }
}
