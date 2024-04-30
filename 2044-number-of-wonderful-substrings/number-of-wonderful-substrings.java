class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Long, Long> map = new HashMap<>();

        map.put(0L, 1L);
        int cumulative_xor = 0;

        long result = 0;

        for(char ch: word.toCharArray()) {
            int shift = ch - 'a';
            cumulative_xor ^= (1 << shift);
            result += map.getOrDefault((long)cumulative_xor, 0L);

            for(char ch1 = 'a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';
                long check_xor = (cumulative_xor ^ (1 << shift));
                result += map.getOrDefault(check_xor, 0L);
            }
            map.put((long)cumulative_xor, map.getOrDefault((long)cumulative_xor, 0L) + 1);
        }
        return result;
    }
}