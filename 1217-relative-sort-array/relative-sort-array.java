class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr2.length; i++) {
            map.put(arr2[i], i);
        }
        
        int largeValue = 1000000000;
        for(int i=0; i<arr1.length; i++) {
            if(!map.containsKey(arr1[i])) {
                map.put(arr1[i], largeValue);
            }
        }

        Comparator<Integer> comparator = (num1, num2) -> {
            int index1 = map.get(num1);
            int index2 = map.get(num2);
            if(index1 == index2) {
                return Integer.compare(num1, num2);
            }
            return Integer.compare(index1, index2);
        };

        List<Integer> list1 = new ArrayList<>();
        for(int num: arr1) {
            list1.add(num);
        }
        Collections.sort(list1, comparator);

        int sortedArray[] = new int[list1.size()];
        for(int i=0; i<list1.size(); i++) {
            sortedArray[i] = list1.get(i);
        }
        return sortedArray;
   }
}