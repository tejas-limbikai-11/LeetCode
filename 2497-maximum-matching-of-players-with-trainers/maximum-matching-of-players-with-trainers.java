class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int result = 0;
        int i = 0, j = 0;

        while(i < n && j < m) {
            if(players[i] <= trainers[j]) {
                result++;
                i++;
            }
            j++;
        }

        return result;
    }
}