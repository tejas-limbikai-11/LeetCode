class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int arr[]: nums) {
            for(int num: arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        } 
        for(int key: map.keySet()) {
            if(map.get(key) == nums.length) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}