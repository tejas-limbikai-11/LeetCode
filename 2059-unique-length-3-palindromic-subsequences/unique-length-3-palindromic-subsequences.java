class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;
        Set<Character> uniqueChars = new HashSet<>();

        for (char ch : s.toCharArray()) {
            uniqueChars.add(ch);
        }

        for (char letter : uniqueChars) {
            int firstIdx = -1;
            int lastIdx = -1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == letter) {
                    if (firstIdx == -1) firstIdx = i;
                    lastIdx = i;
                }
            }
            Set<Character> set = new HashSet<>();
            for (int k = firstIdx + 1; k < lastIdx; k++) {
                if (!set.contains(s.charAt(k))) {
                    set.add(s.charAt(k));
                }
            }
            result += set.size();
        }

        return result;
    }
}