class Solution {
    public int distributeCandies(int n, int limit) {
        int count = 0;

        for(int i=0; i<=limit; i++) {
            for(int j=0; j<=limit; j++) {
                int third = n - i - j;
                if(third >= 0 && third <= limit) count++;
            }
        }
        return count;
    }
}