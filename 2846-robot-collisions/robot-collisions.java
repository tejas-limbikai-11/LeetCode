class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer actualIndex[] = new Integer[n];
        for(int i=0; i<n; i++) actualIndex[i] = i;

        Arrays.sort(actualIndex, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int currIdx: actualIndex) {
            if(directions.charAt(currIdx) == 'R') st.push(currIdx);
            else {
                while(!st.isEmpty() && healths[currIdx] > 0) {
                    int topIdx = st.peek();

                    if(healths[topIdx] > healths[currIdx]) {
                        healths[topIdx] -= 1;
                        healths[currIdx] = 0;
                    }
                    else if(healths[topIdx] < healths[currIdx]) {
                        healths[topIdx] = 0;
                        healths[currIdx] -= 1;
                        st.pop();
                    }
                    else {
                        healths[topIdx] = 0;
                        healths[currIdx] = 0;
                        st.pop();
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(healths[i] > 0) result.add(healths[i]);
        }

        return result;
    }
}