class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        int result = 0;
        int length = 1;
        int prevColor = colors[0];

        for(int j=1; j < n + k - 1; j++) {
            if(colors[j % n] != prevColor) {
                length++;
                prevColor = colors[j % n];
            }
            else length = 1;

            if(length >= k) result++;
        }
        
        return result;
    }
}