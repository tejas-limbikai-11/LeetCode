class Solution {
    public int firstUniqChar(String s) {
        StringBuilder str = new StringBuilder("");
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            q.offer(ch);
            freq[ch - 'a']++;
            
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            } 
            
            if(q.isEmpty()) str.append('$');
            else str.append(q.peek());
        }
        
        String ans = str.toString();
        char c = ans.charAt(ans.length()-1);

        for(int i=0; i<s.length(); i++) {
            if(c == s.charAt(i)) {
                return i;
            }
        }

        return -1;
    }
}