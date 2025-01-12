class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 != 0) return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            char lock = locked.charAt(i);

            if(lock == '0') {
                unlocked.push(i);
            }
            else {
                if(ch == '(') open.push(i);
                else {
                    if(!open.isEmpty()) open.pop();
                    else if(!unlocked.isEmpty()) {
                        unlocked.pop();
                    }
                    else return false;
                }
            }
        }

        while(!open.isEmpty() && !unlocked.isEmpty() && open.peek() < unlocked.peek()) {
            open.pop();
            unlocked.pop();
        }
        return open.isEmpty();
    }
}