class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<int[]> projects = new ArrayList<>();
        for(int i=0; i<profits.length; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        
        projects.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while(k-- > 0) {
            while(i < profits.length && projects.get(i)[0] <= w) {
                pq.add(projects.get(i)[1]);
                i++;
            }
            if(pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }
}