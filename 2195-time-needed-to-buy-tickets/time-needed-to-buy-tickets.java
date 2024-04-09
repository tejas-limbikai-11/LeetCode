class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        for(int i=0; i<tickets.length; i++) q.offer(i);

        while(!q.isEmpty()) {
            int idx = q.poll();
            tickets[idx]--;
            time++;
            if(tickets[idx] == 0 && idx == k) {
                return time;
            }
            if(tickets[idx] > 0) {
                q.offer(idx);
            }
        }
        return time;
    }
}