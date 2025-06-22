class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int count = (n % k == 0) ? (n / k) : (n / k + 1);
        String[] result = new String[count];
        int idx = 0;
        int i = 0;

        for (i = 0; i + k <= n; i += k) {
            String temp = s.substring(i, i + k);
            result[idx] = temp;
            idx++;
        }

        if (idx < count) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i));
            int fillsNeeded = k - sb.length();
            for (int j = 0; j < fillsNeeded; j++) {
                sb.append(fill);
            }
            result[idx] = sb.toString();
        }

        return result;
    }
}