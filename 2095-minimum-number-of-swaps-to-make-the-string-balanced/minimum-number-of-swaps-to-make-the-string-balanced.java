class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '[') {
                stack.push(ch);
            }
            else if(!stack.isEmpty() && ch == ']') {
                stack.pop();
            }
        }

        int noOfOpenBrackets = stack.size();   //no of '['

        return (noOfOpenBrackets + 1) / 2;
    }
}