class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();

        for(char c: num.toCharArray()) {
            while(k>0 && !s.isEmpty() && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }

        while(k > 0) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        
        while(!s.isEmpty()) {
            sb.insert(0, s.pop());
        }

        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}