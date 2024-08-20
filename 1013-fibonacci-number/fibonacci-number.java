class Solution {
    public int fib(int n) {
        // int f[] = new int[n+1];
        // return fibMemoization(n, f);

        // return fibTabulation(n);
        return constantSpace(n);
    }

/*
    public static int fibMemoization(int n, int f[]) {         //O(n)
        if(n == 0 || n == 1) return n;
        if(f[n] != 0) return f[n];
        f[n] = fibMemoization(n-1, f) + fibMemoization(n-2, f);
        return f[n];
    }  
*/ 

    // public static int fibTabulation(int n) {
    //     if(n == 0) return 0;
    //     int dp[] = new int[n+1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     for(int i=2; i<=n; i++) {
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }

    public static int constantSpace(int n) {
        if(n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        int c = 0;

        for(int i = 1; i< n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}