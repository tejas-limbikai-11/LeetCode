class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        return solve(expression);
    }

    public List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftSubstring = solve(s.substring(0, i));
                List<Integer> rightSubstring = solve(s.substring(i + 1));

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
            result.add(Integer.parseInt(s));
        }
        return result;
    }
    
}