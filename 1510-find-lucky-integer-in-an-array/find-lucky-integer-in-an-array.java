class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()) {
            if(map.get(key) == key) {
                result = Math.max(result, key);
            } 
        }

        return result;
    }
}