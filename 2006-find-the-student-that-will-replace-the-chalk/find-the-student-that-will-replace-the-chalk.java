class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int i = 0;
        long sum = 0;

        for(int num: chalk) {
            sum += num;
        }
        
        k = (int) (k % sum);

        while(k > 0) {
            k -= chalk[i%n];
            if(k >= 0) i++;
        }
        return i % n;
    }
}