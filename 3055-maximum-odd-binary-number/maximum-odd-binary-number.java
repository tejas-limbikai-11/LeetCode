class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int zeros = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                ones++;
            } else{
                zeros++;
            }
        }

        StringBuilder ans = new StringBuilder("");
        if(ones == 1) {
            while(zeros != 0) {
                ans.append("0");
                zeros--;
            }
            ans.append("1");
        } else {
            while(ones != 1) {
                ans.append("1");
                ones--;
            }
            while(zeros != 0) {
                ans.append("0");
                zeros--;
            }
            ans.append("1");
        }

        return ans.toString();
    }
}