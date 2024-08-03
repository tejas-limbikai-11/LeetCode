class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if(sign == '-') {
                    stack.push(-num);
                }
                if(sign == '+') {
                    stack.push(num);
                }
                if(sign == '*') {
                    int top = stack.pop();
                    stack.push(top * num);
                }
                if(sign == '/') {
                    int top = stack.pop();
                    stack.push(top / num);
                }
                sign = ch;
                num = 0;
            }
        }
        
        int result = 0;
        for(int i: stack) {
            result += i;
        }
        return result;
    }
}