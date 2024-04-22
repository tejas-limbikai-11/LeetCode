class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (set.contains(start)) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size -- > 0) {
                String curr = queue.poll();
                
                if(curr.equals(target)) return level;

                fillNeighbours(queue, new StringBuilder(curr), set);
            }
            level++;
        }
        return -1;
    }

    public void fillNeighbours(Queue<String> queue, StringBuilder curr, Set<String> set) {
        for(int i=0; i<4; i++) {
            char ch = curr.charAt(i);
            char inc = ch == '9' ? '0' : (char) (ch + 1);
            char dec = ch == '0' ? '9' : (char) (ch - 1);

            curr.setCharAt(i, inc);
            String incStr = curr.toString();
            if(!set.contains(incStr)) {
                set.add(incStr);
                queue.offer(incStr);
            }

            curr.setCharAt(i, dec);
            String decStr = curr.toString();
            if(!set.contains(decStr)) {
                set.add(decStr);
                queue.offer(decStr);
            }

            curr.setCharAt(i, ch);
        }
    }
}