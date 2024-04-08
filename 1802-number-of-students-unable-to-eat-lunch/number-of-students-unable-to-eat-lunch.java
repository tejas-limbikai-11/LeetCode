class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int notServed = 0;

        for(int i=sandwiches.length-1; i>=0; i--) st.push(sandwiches[i]);
        for(int i: students) queue.offer(i);

        while (true) {
            if(st.peek() == queue.peek()) {
                notServed = 0;
                st.pop();
                queue.poll();
            }
            else {
                notServed++;
                int temp = queue.poll();
                queue.offer(temp);
            }
            if(queue.size() == notServed) break;
        }

        return notServed;
    }
}