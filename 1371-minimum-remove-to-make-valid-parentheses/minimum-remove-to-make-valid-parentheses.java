class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                sb.append(c);
                count++;
            }
            else if(c == ')' && count > 0) {
                sb.append(c);
                count--;
            }
            else if(c != ')') {
                sb.append(c);
            }
        }

        for(int i = sb.length()-1; i>=0; i--) {
            if(sb.charAt(i) == '(' && count > 0) {
                count--;
            }
            else {
                ans.append(sb.charAt(i));
            }
        }
        return ans.reverse().toString();
    }
}