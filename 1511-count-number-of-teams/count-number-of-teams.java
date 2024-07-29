class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;

        for(int j=1; j<n-1; j++) {
            int countSmallerLeft = 0;
            int countLargerLeft = 0;
            for(int i=0; i<j; i++) {
                if(rating[i] < rating[j]) countSmallerLeft++;
                if(rating[i] > rating[j]) countLargerLeft++;
            }

            int countSmallerRight = 0;
            int countLargerRight = 0;
            for(int k=j+1; k<n; k++) {
                if(rating[k] < rating[j]) countSmallerRight++;
                if(rating[k] > rating[j]) countLargerRight++;
            }

            teams += (countSmallerLeft * countLargerRight);
            teams += (countLargerLeft * countSmallerRight);
        }
        return teams;
    }
}