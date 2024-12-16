class Solution {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    int n = classes.length;
    PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

    for(int i=0; i<n; i++) {
        int p = classes[i][0];
        int t = classes[i][1];
        double PR = (double) p / t;
        double newPR = (double) (p + 1) / (t + 1);
        pq.offer(new double[] {newPR - PR, i});
    }

    while (extraStudents-- > 0) {
        double[] curr = pq.poll();
        double diff = curr[0];
        int idx = (int) curr[1];     
        classes[idx][0] += 1;
        classes[idx][1] += 1;

        int p = classes[idx][0];   
        int t = classes[idx][1];   
        double PR = (double) p / t;
        double newPR = (double) (p + 1) / (t + 1);
        pq.offer(new double[]{newPR - PR, idx});
    }

    double result = 0;
    for(int i=0; i<n; i++) {
        int p = classes[i][0];
        int t = classes[i][1];
        result += (double) p / t;
    }
    return result / n;
  }
}