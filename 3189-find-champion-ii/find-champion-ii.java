class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];

            indegree[y]++;
        }

        int count = 0;
        int result = 0;

        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                result = i;
                count++;
            }
        }

        return (count == 1) ? result : -1;
    }
}