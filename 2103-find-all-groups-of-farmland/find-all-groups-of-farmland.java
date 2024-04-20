class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(land[i][j] == 1) {
                    solve(land, i, j, list);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public void solve(int[][] land, int x, int y, List<int[]> list) {
        int m = land.length;
        int n = land[0].length;

        int endX = x;
        int endY = y;

        while(endX+1 < m && land[endX+1][y] == 1) {
            land[endX+1][y] = 0;
            endX++;
        }

        while(endY+1 < n && land[x][endY+1] == 1) {
            land[x][endY+1] = 0;
            endY++;
        }

        for(int i=x; i<=endX; i++) {
            for(int j=y; j<=endY; j++) {
                land[i][j] = 0;
            }
        }

        list.add(new int[] {x, y, endX, endY});
    }
}