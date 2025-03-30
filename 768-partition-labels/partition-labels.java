class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> init = new HashMap<>();
        for(char ch: s.toCharArray()) {
            init.put(ch, init.getOrDefault(ch, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            int count = 0;
            for(char ch: map.keySet()) {
                if(map.get(ch) == init.get(ch)) count++;
            }
            if(count == map.size()) {
                result.add(j - i + 1);
                i = j + 1;
                map.clear();
            }
            j++;
        }
        return result;
    }
}