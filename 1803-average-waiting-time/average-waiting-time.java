class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        double count = 0;

        for(int i=0; i<customers.length; i++) {
            if(count >= customers[i][0]) {
                count += customers[i][1];
            } else {
                count = customers[i][0] + customers[i][1];
            }
            sum += count - customers[i][0];
        }

        double average = sum / customers.length;
        return average;
    }
}