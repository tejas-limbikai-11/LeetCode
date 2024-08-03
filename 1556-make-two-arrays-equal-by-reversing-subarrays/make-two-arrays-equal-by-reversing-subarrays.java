class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int num: target) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        for(int num: arr) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        return map1.equals(map2);
    }
}