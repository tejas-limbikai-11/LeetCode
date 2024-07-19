class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int answer: answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        int result = 0;

        for(int key: map.keySet()) {
            int groupSize = key + 1;
            int groups = (int) Math.ceil((double) map.get(key) / groupSize);
            result += (groups * groupSize);
        }
        return result;
    }
}