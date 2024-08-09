class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1) return result;
        result.add(new ArrayList<>(Arrays.asList(1, 1)));
        if(numRows == 2) return result;


        for(int i=1; i<numRows-1; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=0; j<result.get(i).size()-1; j++) {
                int sum = result.get(i).get(j) + result.get(i).get(j+1);
                temp.add(sum);
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}