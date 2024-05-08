class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(score[i], i);
        }
        String result[] = new String[n];
        Arrays.sort(score);

        for(int i=n-1; i>=0; i--) {
            int x = map.get(score[i]);

            if(i == n-1) result[x] = "Gold Medal";
            else if(i == n-2) result[x] = "Silver Medal";
            else if(i == n-3) result[x] = "Bronze Medal";
            else result[x] = String.valueOf(n-i);
        }
        return result;
    }
}