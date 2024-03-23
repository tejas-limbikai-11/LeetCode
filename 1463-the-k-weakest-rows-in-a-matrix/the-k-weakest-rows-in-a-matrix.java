class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        for(int i=0; i<mat.length; i++) {
            int count = 0;
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) count++;
            }
            pq.offer(new int[] {count, i});
        }

        int[] weakestRows = new int[k];
        for(int i=0; i<k; i++) {
            weakestRows[i] = pq.poll()[1];
        }

        return weakestRows;
    }
}