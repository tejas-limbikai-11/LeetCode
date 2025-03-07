class Solution {
    private boolean[] sieveHelper(int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=right; i++) {
            if(isPrime[i]) {
                for(int j=2; i*j<=right; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveHelper(right);

        List<Integer> prime = new ArrayList<>();
        for(int num=left; num<=right; num++) {
            if(isPrime[num]) prime.add(num);
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for(int i=1; i<prime.size(); i++) {
            int diff = prime.get(i) - prime.get(i-1);
            if(diff < minDiff) {
                minDiff = diff;
                result[0] = prime.get(i-1);
                result[1] = prime.get(i);
            }
        }
        return result;
    }
}