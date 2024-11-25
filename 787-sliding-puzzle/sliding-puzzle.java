class Solution {
    public int slidingPuzzle(int[][] board) {
        int level = 0;
        StringBuilder input = new StringBuilder();
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
                input.append(board[i][j]);
            }
        }

        String target = "123450";

        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{1, 3});
        map.put(1, new int[]{0, 2, 4});
        map.put(2, new int[]{1, 5});
        map.put(3, new int[]{0, 4});
        map.put(4, new int[]{1, 3, 5});
        map.put(5, new int[]{4, 2});

        Queue<String> queue = new LinkedList<>();
        queue.offer(input.toString());
    
        Set<String> visited = new HashSet<>();
        visited.add(input.toString());

        while(!queue.isEmpty()) {
            int n = queue.size();

            while(n-- > 0) {
                String curr = queue.poll();

                if(curr.equals(target)) {
                    return level;
                }

                int indexOfZero = curr.indexOf('0');

                for(int swapIdx: map.get(indexOfZero)) {
                    char[] newStateArray = curr.toCharArray();

                    char temp = newStateArray[indexOfZero];
                    newStateArray[indexOfZero] = newStateArray[swapIdx];
                    newStateArray[swapIdx] = temp;

                    String newState = new String(newStateArray);

                    if(!visited.contains(newState)) {
                        queue.offer(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}