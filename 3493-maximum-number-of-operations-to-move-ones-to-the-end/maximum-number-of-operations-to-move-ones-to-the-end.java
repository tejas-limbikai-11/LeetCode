class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int ans = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                ans += count;

                while(i < s.length() && s.charAt(i) != '1') {
                    i++;
                }
            }
            count++;
        }
        return ans;
    }
}