class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                count++;
            } else if(count > 0) {
                count --;
            }
            else sb.append(ch);
        }
        return sb.reverse().toString();
    }
}

