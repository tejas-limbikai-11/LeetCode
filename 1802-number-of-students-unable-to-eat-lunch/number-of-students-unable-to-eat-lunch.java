class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int arr[] = new int[2];
        for(int i: students) arr[i]++;

        int n = sandwiches.length;
        for(int i=0; i<n; i++) {
            if(arr[sandwiches[i]] == 0) return n-i;
            arr[sandwiches[i]]--;
        }   
        return 0;
    }
}