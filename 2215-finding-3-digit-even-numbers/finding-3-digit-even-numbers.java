class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(digits[i] == 0) continue;
            int one = digits[i];
            for(int j=0; j<n; j++) {
                if(j == i) continue;
                int two = digits[j];

                for(int k=0; k<n; k++) {
                    if(k == i || k == j) continue;
                    int three = digits[k];
                    int ans = one * 100 + two * 10 + three;
                    if(ans % 2 == 0) map.put(ans, 1);
                }
            }
        }
        int[] result = new int[map.size()];
        int i = 0;
        for(int key: map.keySet()) {
            result[i] = key;
            i++;
        }
        Arrays.sort(result);
        return result;
    }
}