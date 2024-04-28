class Solution {
    public boolean canMakeSquare(char[][] grid) {
        char ch = grid[1][1];
        int W = 0, B = 0;
        if (ch == 'W') W++;
        else B++;

        //first box
        if (grid[0][0] == 'W') W++;
        else B++;
        if (grid[0][1] == 'W') W++;
        else B++;
        if (grid[1][0] == 'W') W++;
        else B++;
        if (W > 2 || B > 2) return true;

        W = 0;
        B = 0;
        if (ch == 'W') W++;
        else B++;

        //second box
        if (grid[0][1] == 'W') W++;
        else B++;
        if (grid[0][2] == 'W') W++;
        else B++;
        if (grid[1][2] == 'W') W++;
        else B++;
        if (W > 2 || B > 2) return true;

        W = 0;
        B = 0;
        if (ch == 'W') W++;
        else B++;

        //third box
        if (grid[1][0] == 'W') W++;
        else B++;
        if (grid[2][0] == 'W') W++;
        else B++;
        if (grid[2][1] == 'W') W++;
        else B++;
        if (W > 2 || B > 2) return true;

        W = 0;
        B = 0;
        if (ch == 'W') W++;
        else B++;

        //fourth box
        if (grid[1][2] == 'W') W++;
        else B++;
        if (grid[2][1] == 'W') W++;
        else B++;
        if (grid[2][2] == 'W') W++;
        else B++;
        if (W > 2 || B > 2) return true;

        return false;
    }
}
