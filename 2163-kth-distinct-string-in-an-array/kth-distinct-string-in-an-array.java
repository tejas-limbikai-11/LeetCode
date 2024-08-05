class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for(String s: arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(String key: map.keySet()) {
            if(map.get(key) == 1) {
                list.add(key);
            }
        }
        
        if(list.size() < k) return "";

        return list.get(k-1);
    }
}