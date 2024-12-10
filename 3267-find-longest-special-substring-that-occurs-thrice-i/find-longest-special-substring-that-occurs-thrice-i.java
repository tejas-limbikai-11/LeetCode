class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        int maxLength = -1;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String str = s.substring(i, j+1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        for(String str: map.keySet()) {
            if(map.get(str) > 2) {
                if(isSame(str)) {
                    maxLength = Math.max(maxLength, str.length());
                }
            }
        }
        return maxLength;
    }

    public boolean isSame(String str) {
        if(str.length() <= 1) return true;

        char ch = str.charAt(0);

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) != ch) return false;
        }
        return true;
    }
}