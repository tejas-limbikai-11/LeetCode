class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int finalPrices[] = new int[prices.length];

        for(int i=prices.length-1; i>=0; i--) {
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                finalPrices[i] = prices[i];
            } else{
                finalPrices[i] = prices[i] - prices[s.peek()];
            }

            s.push(i);
        }

        return finalPrices;
    }
}