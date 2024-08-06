class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int result = 0;

        for(int i=0; i<n; i++) {
            char ch = columnTitle.charAt(i);
            result = 26 * result + (ch - 'A' + 1);
        }
        return result;
    }
}
