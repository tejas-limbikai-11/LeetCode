class Solution {
    public int xorOperation(int n, int start) {
        int xor = 0;
        for(int i = 0; i<n; i++){
            int ans = start + 2 * i;
            xor = xor ^ ans;
        }
        return xor;
    }
}