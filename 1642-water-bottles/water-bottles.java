class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = 0;
        int empty = 0;
        int exchange = 0;
        drink += numBottles;

        while(numBottles >= numExchange) {
            exchange = numBottles / numExchange;
            empty = numBottles % numExchange;
            drink += exchange;
            numBottles = empty + exchange;
        }
        return drink;
    }
}