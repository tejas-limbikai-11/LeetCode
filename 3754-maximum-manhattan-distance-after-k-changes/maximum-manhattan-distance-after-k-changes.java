class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int e = 0, w = 0, cn = 0, cs = 0;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'E') {
                e++;
            }
            else if (c == 'W') {
                w++;
            }
            else if (c == 'N') {
                cn++;
            }
            else if (c == 'S') {
                cs++;
            }

            int ne1 = (e + cn) - (w + cs);
            int ne2 = w + cs;
            int ne3 = ne1 + 2 * Math.min(k, ne2);

            int nw1 = (w + cn) - (e + cs);
            int nw2 = e + cs;
            int nw3 = nw1 + 2 * Math.min(k, nw2);

            int se1 = (e + cs) - (w + cn);
            int se2 = w + n;
            int se3 = se1 + 2 * Math.min(k, se2);

            int sw1 = (w + cs) - (e + cn);
            int sw2 = e + n;
            int sw3 = sw1 + 2 * Math.min(k, sw2);

            int best = Math.max(Math.max(ne3, nw3), Math.max(se3, sw3));
            best = Math.max(best, 0);
            best = Math.min(best, i + 1);

            ans = Math.max(ans, best);
        }
        return ans;
    }
}