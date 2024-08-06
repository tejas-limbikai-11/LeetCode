class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char ch: word.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(freqMap.values());
        Collections.sort(list, Collections.reverseOrder());

        int result = 0;

        for(int i=0; i<list.size(); i++) {
            result += (i / 8 + 1) * list.get(i);
        }
        return result;
    }
}