class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        int[] extended = new int[n + k - 1];
        System.arraycopy(colors, 0, extended, 0, n);
        System.arraycopy(colors, 0, extended, n, k - 1);

        int result = 0;
        int i=0, j=1;

        while(j < n + k - 1) {
            if(extended[j] == extended[j-1]) {
                i = j;
                j++;
                continue;
            }
            if(j - i + 1 == k) {
                result++;
                i++;
            }
            j++;
        }
        
        return result;
    }
}