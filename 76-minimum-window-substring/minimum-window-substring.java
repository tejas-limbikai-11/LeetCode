class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n) return "";

        Map<Character, Integer> map = new HashMap<>();

        for(char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = t.length();
        int i = 0;
        int j = 0;
        int[] ans = new int[] {-1, 0, 0};  // window length, left, right

        while(j < n) {
            char ch = s.charAt(j);

            if(map.getOrDefault(ch, 0) > 0) {
                requiredCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while(requiredCount == 0) {

                if(ans[0] == -1 || (j - i + 1) < ans[0]) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }

                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                if(map.get(s.charAt(i)) > 0) {
                    requiredCount++;
                }

                i++;
            }
            j++;
        }

        if(ans[0] == -1) return "";

        return s.substring(ans[1], ans[2] + 1);
    }
}