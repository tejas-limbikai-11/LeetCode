class Solution {
    public int countLargestGroup(int n) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        
        for(int i=1; i<=n; i++) {
            int sum = sumOfDigits(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(sum));
        }

        for(int key: map.keySet()) {
            if(map.get(key) == maxFreq) result++;
        }

        return result;
    }

    public int sumOfDigits(int num) {
        int sum = 0;

        while(num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}