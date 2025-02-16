class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        Arrays.fill(result, -1);
        boolean[] used = new boolean[n + 1];

        solve(0, n, result, used);
        return result;
    }

    public boolean solve(int i, int n, int[] result, boolean[] used) {
        if(i >= result.length) {
            return true;
        }

        if(result[i] != -1) {
            return solve(i + 1, n, result, used);
        }

        for(int num=n; num>=1; num--) {
            if(used[num]) continue;
            
            //try
            used[num] = true;
            result[i] = num;

            //explore
            if(num == 1) {
                if(solve(i + 1, n, result, used)) {
                    return true;
                }
            }
            else {
                int j = i + result[i];
                if(j < result.length && result[j] == -1) {
                    result[j] = num;
                    if(solve(i + 1, n, result, used)) {
                        return true;
                    }
                    result[j] = -1;
                }
            }

            //undo
            used[num] = false;
            result[i] = -1;
        }
        return false;
    }
}
