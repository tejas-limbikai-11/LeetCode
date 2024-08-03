class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1;

        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+') {
                result += (num * sign);
                num = 0;
                sign = 1;
            }
            else if(ch == '-') {
                result += (num * sign);
                num = 0;
                sign = -1;
            }
            else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            }
            else if(ch == ')') {
                result += (num * sign);
                num = 0;

                int stackSign = stack.pop();
                int lastResult = stack.pop();

                result *= stackSign;
                result += lastResult;
            }
        }
        result += (num * sign);
        return result;
    }
}