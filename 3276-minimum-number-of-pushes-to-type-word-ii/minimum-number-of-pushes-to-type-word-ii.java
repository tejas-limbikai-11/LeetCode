class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char ch: word.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(freqMap.keySet());
        Collections.sort(list, (a, b) -> freqMap.get(b) - freqMap.get(a));

        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        int charAssigned = 0;

        for(char ch: list) {
            map.put(ch, count);
            charAssigned++; 

            if(charAssigned == 8) {
                count++;
                charAssigned = 0;
            }
        }

        int result = 0;
        for(char ch: word.toCharArray()) {
            result += map.get(ch);
        }
        return result;
    }
}