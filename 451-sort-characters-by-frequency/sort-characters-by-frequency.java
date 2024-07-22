class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> {
            return map.get(b) - map.get(a);
        });

        StringBuilder sb = new StringBuilder();
        for(char ch: list) {
            for(int j=0; j<map.get(ch); j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}