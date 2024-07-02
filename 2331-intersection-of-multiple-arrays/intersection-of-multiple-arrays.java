class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1001];
        for(int arr[]: nums) {
            for(int num: arr) {
                count[num]++;
            }
        } 
        for(int i=0; i<count.length; i++) {
            if(count[i] == nums.length) {
                list.add(i);
            }
        }
        return list;
    }
}