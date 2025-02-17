class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        Set<String> result = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        boolean[] used = new boolean[n];

        solve(tiles, used, curr, result);
        return result.size() - 1;
    }

    public void solve(String tiles, boolean[] used, StringBuilder curr, Set<String> result) {
        result.add(curr.toString());

        for(int i=0; i<tiles.length(); i++) {
            if(used[i]) continue;

            curr.append(tiles.charAt(i));
            used[i] = true;

            // explore
            solve(tiles, used, curr, result);

            // backtrack
            used[i] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
