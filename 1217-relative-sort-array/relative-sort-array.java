class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(int num: arr2) {
            if(map.containsKey(num)) {
                for(int i=0; i<map.get(num); i++) result.add(num);
                map.remove(num);
            }
        }

        List<Integer> remaining = new ArrayList<>();
        for(int num: map.keySet()) {
            for(int i=0; i<map.get(num); i++) remaining.add(num);
        }
        Collections.sort(remaining);
        result.addAll(remaining);

        int resultArray[] = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}