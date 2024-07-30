class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] prefix = new int[n];

        if(s.charAt(0) == '1') {
            prefix[0] = 1;
        }

        for(int i=1; i<n; i++) {
            if(s.charAt(i) == '1') {
                prefix[i] = prefix[i-1] + 1;
            }
            else prefix[i] = prefix[i-1];
        }

        int ans = 0;

        for(int i=0; i<n; i++) {
            int one = 0;
            int zero = 0;

            for(int j=i; j<n; j++) {

                if(i == 0) one = prefix[j];
                else one = prefix[j] - prefix[i - 1];

                zero = (j - i + 1) - one;

                if((zero * zero) > one) {   //Not dominant
                    j += (zero * zero - one - 1);
                }
                else if((zero * zero) == one) {     //Dominant
                    ans++;
                }
                else if((zero * zero) < one) {
                    ans++;

                    int diff = (int) Math.sqrt(one) - zero;
                    int nextj = j + diff;

                    if(nextj >= n) ans += (n - j - 1);
                    else ans += diff;

                    j = nextj;
                }
            }
        }
        return ans;
    }
}