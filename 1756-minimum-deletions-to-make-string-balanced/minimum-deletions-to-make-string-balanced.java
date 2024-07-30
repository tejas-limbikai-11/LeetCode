class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == 'b' && ch == 'a') {
                count++;
                stack.pop();
            }
            else stack.push(ch);
        }
        return count;
    }
}