class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int count = 0;

        for (String word : words) {
            boolean allCharAllowed = true;

            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    allCharAllowed = false;
                    break;
                }
            }

            if (allCharAllowed) {
                count++;
            }
        }

        return count;
    }
}
