class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0, x = 0, y = 0;
        int result = 0;
        int[][] direction = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Set<String> set = new HashSet<>();
        for(int[] obs: obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }

        for(int command: commands) {
            if(command == -1) {
                dir++;
                if(dir == 4) dir = 0;
            }
            else if(command == -2) {
                dir--;
                if(dir == -1) dir = 3;
            }
            else {
                while(command-- > 0 && !set.contains((x + direction[dir][0]) + " " + (y + direction[dir][1]))) {
                    x += direction[dir][0];
                    y += direction[dir][1];
                }
            }
            result = Math.max(result, (x * x + y * y));
        }
        return result;
    }
}