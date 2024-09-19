class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer> result = new ArrayList<>();
        return solve(expression, 0, n);
    }

    public List<Integer> solve(String s, int start, int end) {
        List<Integer> result = new ArrayList<>();

        for(int i=start; i<end; i++) {
            char ch = s.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftSubstring = solve(s, start, i);
                List<Integer> rightSubstring = solve(s, i+1, end);

                for(int x: leftSubstring) {
                    for(int y: rightSubstring) {
                        if(ch == '+') {
                            result.add(x+y);
                        }
                        else if(ch == '-') {
                            result.add(x-y);
                        }
                        else if(ch == '*') {
                            result.add(x*y);
                        }
                    }
                }
            }
        }
        if(result.size() == 0) {
            result.add(Integer.parseInt(s.substring(start, end)));
        }
        return result;
    }
}