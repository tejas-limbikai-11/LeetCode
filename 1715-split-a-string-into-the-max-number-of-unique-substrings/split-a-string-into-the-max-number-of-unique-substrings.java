class Solution {
    int count = 0;
    int maxCount = 0;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        solve(0, s, set, count);
        return maxCount;
    }

    public void solve(int i, String s, Set<String> set, int count) {
        if(i >= s.length()) { 
            maxCount = Math.max(maxCount, count);
            return;
        }

        for(int j=i; j<s.length(); j++) {
            String subStr = s.substring(i, j + 1);
            if(!set.contains(subStr)) {
                set.add(subStr);
                solve(j + 1, s, set, count + 1);
                set.remove(subStr);
            }
        }
    }
}