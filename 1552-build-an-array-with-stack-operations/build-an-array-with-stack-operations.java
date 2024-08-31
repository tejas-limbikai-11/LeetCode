class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int i = 1;
        int t = 0;

        while(t < target.length) {
            if(i == target[t]) {
                list.add("Push");
                t++;
            }
            else {
                list.add("Push");
                list.add("Pop");
            }
            i++;
        }
        return list;
    }
}