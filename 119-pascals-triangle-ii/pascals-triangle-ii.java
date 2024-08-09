class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        long prev = 1;
        for(int i=1; i<=rowIndex; i++) {
            long nextVal = prev * (rowIndex - i + 1) / i;
            result.add((int) nextVal);
            prev = nextVal;
        }
        return result;
    }
}