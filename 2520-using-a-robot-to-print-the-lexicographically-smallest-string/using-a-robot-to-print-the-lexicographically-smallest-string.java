class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minCharToRight = new char[n];
        minCharToRight[n-1] = s.charAt(n-1);

        for(int i=n-2; i>=0; i--) {
            minCharToRight[i] = (char)Math.min(s.charAt(i), minCharToRight[i+1]);
        }

        StringBuilder t = new StringBuilder();
        StringBuilder p = new StringBuilder();

        int i = 0;
        while(i < n) {
            t.append(s.charAt(i));
            char minChar = (i + 1 < n) ? minCharToRight[i+1] : s.charAt(i);

            while(t.length() > 0 && t.charAt(t.length() - 1) <= minChar) {
                p.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            i++;
        }

        while(t.length() > 0) {
            p.append(t.charAt(t.length() - 1));
            t.deleteCharAt(t.length() - 1);
        }

        return p.toString();
    }
}