class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(String str: words1) {
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        for(String str: words2) {
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for(String str: words1) {
            if(map1.get(str) == 1 && !map2.containsKey(str)) {
                list.add(str);
            }
        }

        for(String str: words2) {
            if(map2.get(str) == 1 && !map1.containsKey(str)) {
                list.add(str);
            }
        }

        String[] result = new String[list.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}