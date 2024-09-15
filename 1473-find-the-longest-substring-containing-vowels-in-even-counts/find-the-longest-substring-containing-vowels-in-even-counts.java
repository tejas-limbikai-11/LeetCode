class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int[] freq = new int[5];
        map.put("00000", -1);   //Initial state
        int result = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a') {
                freq[0] = (freq[0] + 1) % 2;
            }
            else if(ch == 'e') {
                freq[1] = (freq[1] + 1) % 2;
            }
            else if(ch == 'i') {
                freq[2] = (freq[2] + 1) % 2;
            }
            else if(ch == 'o') {
                freq[3] = (freq[3] + 1) % 2;
            }
            else if(ch == 'u') {
                freq[4] = (freq[4] + 1) % 2;
            }
            StringBuilder sb = new StringBuilder();
            for(int f: freq) {
                sb.append(f);
            }

            if(map.containsKey(sb.toString())) {
                result = Math.max(result, i - map.get(sb.toString()));
            }
            else map.put(sb.toString(), i);
        }
        return result;
    }
}