class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        result.add(new ArrayList<>(Arrays.asList(1, 1)));

        for(int i=1; i<rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=0; j<result.get(i).size()-1; j++) {
                int sum = result.get(i).get(j) + result.get(i).get(j+1);
                temp.add(sum);
            }
            temp.add(1);
            result.add(temp);
        }

        for(int i=0; i<result.size(); i++) {
            return result.get(rowIndex);
        }
        return new ArrayList<>();
    }
}