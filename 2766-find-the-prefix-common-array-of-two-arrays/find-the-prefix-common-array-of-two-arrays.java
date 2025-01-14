class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int common = 0;
        int[] result = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for(int i=0; i<n; i++) {
            if(setA.contains(B[i])) common++; 
            if(setB.contains(A[i])) common++; 
            if(A[i] == B[i]) common++;

            setA.add(A[i]);
            setB.add(B[i]);

            result[i] = common;
        }
        return result;
    }
}