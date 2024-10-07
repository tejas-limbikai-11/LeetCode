class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty() && ch == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            else if(!stack.isEmpty() && ch == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else stack.push(ch);
        }

        return stack.size();
    }
}