class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);

        return solve(0, 0, g, s);
    }

    public int solve(int i, int j, int[] g, int[] s) {
        if(i == g.length || j == s.length) return 0;

        if(g[i] <= s[j]) {
            return 1 + solve(i + 1, j + 1, g, s);
        }
        else return solve(i, j + 1, g, s);
    }
}