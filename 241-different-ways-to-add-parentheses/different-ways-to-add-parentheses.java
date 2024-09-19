class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        return solve(expression, 0, n, map);
    }

    public List<Integer> solve(String s, int start, int end, Map<String, List<Integer>> map) {
        List<Integer> result = new ArrayList<>();

        String key = start + "," + end;
        if(map.containsKey(key)) return map.get(key);

        for(int i=start; i<end; i++) {
            char ch = s.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftSubstring = solve(s, start, i, map);
                List<Integer> rightSubstring = solve(s, i+1, end, map);

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
        map.put(key, result);
        return result;
    }
}