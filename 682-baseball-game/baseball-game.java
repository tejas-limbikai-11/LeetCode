class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();

        for(String str: operations) {
            if(str.equals("C")) {
                s.pop();
            } 
            else if(str.equals("D")) {
                int score = s.peek();
                s.push(score * 2);
            }
            else if(str.equals("+") && s.size() > 1) {
                int prev1 = s.pop();
                int prev2 = s.peek();
                s.push(prev1);
                s.push(prev1 + prev2);
            }
            else s.push(Integer.valueOf(str));
        }

        int sum = 0;
        while(!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }
}