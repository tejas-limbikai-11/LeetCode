class Solution {
    public String fractionAddition(String exp) {
        int nume = 0;
        int deno = 1;

        int n = exp.length();
        int i = 0;

        while(i < n) {
            int currNume = 0;
            int currDeno = 0;

            boolean isNegative = (exp.charAt(i) == '-');

            if(exp.charAt(i) == '+' || exp.charAt(i) == '-') i++;

            while(i < n && Character.isDigit(exp.charAt(i))) {
                int val = exp.charAt(i) - '0';
                currNume = (10 * currNume) + val;
                i++;
            }

            i++;   //skip the division character '/'

            if(isNegative) currNume *= -1;

            while(i < n && Character.isDigit(exp.charAt(i))) {
                int val = exp.charAt(i) - '0';
                currDeno = (10 * currDeno) + val;
                i++;
            }

            nume = currNume * deno + nume * currDeno;
            deno = deno * currDeno;
        }
        int gcd = gcd(Math.abs(nume), deno);
        nume /= gcd;
        deno /= gcd;

        return nume + "/" + deno;
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}