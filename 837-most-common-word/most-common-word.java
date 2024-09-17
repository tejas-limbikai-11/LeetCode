class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String str: banned) set.add(str);
        Map<String, Integer> map = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W", " ").toLowerCase().split("\\s");

        int maxFreq = 0;
        String result = "";

        for(String word: words) {
            if(!set.contains(word) && word.length() > 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);

                if(map.get(word) > maxFreq) {
                    maxFreq = map.get(word);
                    result = word;
                }
            }
        }
        return result;
    }
}