class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //Row wise cumulative sum
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int result = 0;
        //Find the "No. of subarrays with sum k" in the downward direction (LeetCode 560)
        for(int startCol = 0; startCol < cols; startCol++) {
            for(int currCol = startCol; currCol < cols; currCol++) {

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for(int row = 0; row < rows; row++) {
                    if(startCol > 0) { //remove previous cumulative sum
                        sum += matrix[row][currCol] - matrix[row][startCol - 1];
                    }
                    else sum += matrix[row][currCol];

                    if(map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return result;
    }
}