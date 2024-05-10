import java.util.PriorityQueue;

class Solution {
    static class Fraction implements Comparable<Fraction>{
        double f;
        int i;
        int j;
          
        public Fraction(double f, int i, int j) {
            this.f = f;
            this.i = i;
            this.j = j;
        }
        @Override
        public int compareTo(Fraction p2) {
            return Double.compare(this.f, p2.f);
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int ans[] = new int[2];
        PriorityQueue<Fraction> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { 
                pq.add(new Fraction(((double)arr[i] / arr[j]), arr[i], arr[j]));
            }
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Fraction curr = pq.poll();
            if (++count == k) {
                ans[0] = curr.i;
                ans[1] = curr.j;
                return ans;
            }
        }
        return ans;
    }
}
