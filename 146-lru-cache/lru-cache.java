class LRUCache {
    Queue<Integer> queue;
    Map<Integer, Integer> map;
    int c;

    public LRUCache(int capacity) {
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
        this.c = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            queue.remove(key);
            queue.offer(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            queue.remove(key);
        }
        if(queue.size() == c) {
            map.remove(queue.poll());
        }
        queue.offer(key);
        map.put(key, value);
    }
}
