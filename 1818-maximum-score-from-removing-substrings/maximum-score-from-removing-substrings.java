class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int score = 0;

        for(char ch: s.toCharArray()) {
            if(x > y) {
                if(!stack.isEmpty() && stack.peek() == 'a' && ch == 'b') {
                    stack.pop();
                    score += x;
                }   
                else stack.push(ch);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == 'b' && ch == 'a') {
                    stack.pop();
                    score += y;
                }
                else stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        String newS = sb.toString();

        for(char ch: newS.toCharArray()) {
            if(x > y) { 
                if(!stack.isEmpty() && stack.peek() == 'b' && ch == 'a') {
                    stack.pop();
                    score += y;
                }
                else stack.push(ch);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == 'a' && ch == 'b') {
                    stack.pop();
                    score += x;
                } 
                else stack.push(ch);
            }
        }

        return score;
    }
}