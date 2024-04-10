class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.sort(deck); 
        for(int i=0; i<deck.length; i++) queue.offer(i);

        int res[] = new int[deck.length];

        for(int i=0; i<deck.length; i++){
            res[queue.poll()] = deck[i];
            queue.offer(queue.poll());   
        }
        
        return res;
    }
}