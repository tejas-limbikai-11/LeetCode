class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int startNum=1; startNum<=9; startNum++) {
            solve(startNum, n, result);
        }
        return result;
    }

    public void solve(int currNum, int n, List<Integer> result) {
        if(currNum > n) return;

        result.add(currNum);

        for(int append=0; append<=9; append++) {
            int newNum = (currNum * 10) + append;
            if(newNum > n) return;
            solve(newNum, n, result);
        }
    }
}