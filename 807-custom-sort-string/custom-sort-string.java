class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch: order.toCharArray()) {
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                while(count > 0) {
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);
            }
        }

        for(char ch: map.keySet()) {
            int count = map.get(ch);
            while(count > 0) { 
                sb.append(ch);
                count--;
            }
        }

        return sb.toString();
    }
}