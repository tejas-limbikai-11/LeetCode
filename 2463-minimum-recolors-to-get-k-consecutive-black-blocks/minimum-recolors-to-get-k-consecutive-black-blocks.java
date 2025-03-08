class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int result = k;
        int i=0, j=0;
        int W=0;

        while(j < n) {
            if(blocks.charAt(j) == 'W') {
                W++;
            }

            if(j - i + 1 == k) {
                result = Math.min(result, W);

                if(blocks.charAt(i) == 'W') {
                    W--;
                }
                i++;
            }
            j++;
        }

        return result;
    }
}