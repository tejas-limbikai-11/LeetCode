class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                double div = (double) arr[i] / arr[j];
                pq.offer(new double[]{div, (double) arr[i], (double) arr[j]});
                if(pq.size() > k) pq.poll();
            }
        }
        double kth[] = pq.peek();
        int result[] = new int[2];
        result[0] = (int) kth[1];
        result[1] = (int) kth[2];
        return result;
    }
}