class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> temp = new ArrayList<>();
        solve(temp, map, result, n);

        return result;
    }

    public void solve(List<Integer> temp, Map<Integer, Integer> map, List<List<Integer>> result, int n) {
        if(temp.size() == n) {
            result.add(new ArrayList<>(temp)); 
            return;
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count == 0) continue;

            temp.add(num);
            map.put(num, map.get(num) - 1);

            solve(temp, map, result, n);

            temp.remove(temp.size() - 1);
            map.put(num, map.get(num) + 1);
        }
    }
}