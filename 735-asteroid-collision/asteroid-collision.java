class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for(int i: asteroids) {
            if(i > 0 || s.isEmpty()) {
                s.push(i);
            }
            else {
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() == Math.abs(i)) s.pop();
                else if(!s.isEmpty() && s.peek() > Math.abs(i)) continue;
                else s.push(i);
            }
        }

        int[] ans = new int[s.size()];
        int i = 1;
        while(!s.isEmpty()) {
            ans[ans.length - i] = s.pop();
            i++;
        }

        return ans;
    }
}