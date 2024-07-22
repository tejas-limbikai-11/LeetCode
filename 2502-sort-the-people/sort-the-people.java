class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();

        for(int i=0; i<heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        String[] result = new String[heights.length];

        int i = 0;
        for(int a: list) {
            result[i] = map.get(a);
            i++;
        }
        return result;
    }
}