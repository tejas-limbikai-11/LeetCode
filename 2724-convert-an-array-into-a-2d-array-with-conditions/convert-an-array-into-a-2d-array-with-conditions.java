class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while(!map.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Integer> keysToDelete = new ArrayList<>();

            for(int key: map.keySet()) {
                list.add(key);
                map.put(key, map.getOrDefault(key, 0) - 1);
                if(map.get(key) == 0) {
                    keysToDelete.add(key);
                }
            }
            for(int key: keysToDelete) {
                map.remove(key);
            }
            result.add(list);
        }
        return result;
    }
}