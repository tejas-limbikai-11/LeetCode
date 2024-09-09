class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode curr = head;
        int[][] matrix = new int[m][n];
        for(int[] arr: matrix) Arrays.fill(arr, -1);

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int i = 0, j = 0;

        while(curr != null) {
            matrix[i][j] = curr.val;

            curr = curr.next;

            int nextI = i + dir[d][0];
            int nextJ = j + dir[d][1];

            if(nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || matrix[nextI][nextJ] != -1) {
                d = (d+1) % 4;
                nextI = i + dir[d][0];
                nextJ = j + dir[d][1];
            }
            i = nextI;
            j = nextJ;
        }
        return matrix;
    }
}