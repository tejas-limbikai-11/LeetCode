class Solution {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0) + 1;
    }
}