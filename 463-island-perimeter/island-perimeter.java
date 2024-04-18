class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return bfs(grid, i, j);
                }
            }
        }
        return -1;
    }

    public int bfs(int grid[][], int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        grid[i][j] = -1;

        while(!q.isEmpty()) {
            int[] it = q.poll();
            for(int dir[]: directions) {
                int a = it[0] + dir[0];
                int b = it[1] + dir[1];

                if(a < 0 || a >= m || b < 0 || b >= n || grid[a][b] == 0) {
                    perimeter++;
                }
                else if(grid[a][b] == -1) continue;
                else {
                    q.offer(new int[] {a, b});
                    grid[a][b] = -1;
                }
            }
        }
        return perimeter;
    }
}