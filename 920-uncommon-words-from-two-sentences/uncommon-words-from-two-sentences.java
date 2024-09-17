class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String[] concatWords = (s1 + " " + s2).split(" ");

        for(String str: concatWords) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for(String str: map.keySet()) {
            if(map.get(str) == 1) {
                list.add(str);
            }
        }
        return list.toArray(new String[0]);
    }
}