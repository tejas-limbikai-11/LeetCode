class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int i = 0;
        while(i < n) {
            if(formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;

                StringBuilder sb = new StringBuilder();
                while(i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }

                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for(String key: top.keySet()) {
                    int value = top.get(key);
                    top.put(key, value * multiplier);
                }

                // Merging
                for(String key: top.keySet()) {
                    Map<String, Integer> oldMap = stack.peek();
                    oldMap.put(key, oldMap.getOrDefault(key, 0) + top.get(key));
                }
            }
            else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i));
                i++;

                while(i<n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i));
                    i++;
                }

                StringBuilder num = new StringBuilder();
                while(i < n && Character.isDigit(formula.charAt(i))) {
                    num.append(formula.charAt(i));
                    i++;
                }

                int count = num.length() > 0 ? Integer.parseInt(num.toString()) : 1;
                Map<String, Integer> oldMap = stack.peek();
                oldMap.put(element.toString(), oldMap.getOrDefault(element.toString(), 0) + count);
            }   
        }

        //Only one map is left in stack
        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder result = new StringBuilder();

        for(String key: sortedMap.keySet()) {
            result.append(key);
            int count = sortedMap.get(key);
            if(count > 1) result.append(count); 
        }
        return result.toString();
    }
}