class NumberContainers {
  Map<Integer, Integer> map;
  Map<Integer, PriorityQueue<Integer>> pqMap;

  public NumberContainers() {
    map = new HashMap<>();
    pqMap = new HashMap<>();
  }

  public void change(int index, int number) {
    map.put(index, number);
    pqMap.putIfAbsent(number, new PriorityQueue<>());
    pqMap.get(number).offer(index);
  }

  public int find(int number) {
    if (!pqMap.containsKey(number)) {
      return -1;
    }
    PriorityQueue<Integer> pq = pqMap.get(number);

    while (!pq.isEmpty()) {
      int idx = pq.peek();
      if (map.get(idx) == number) {
        return idx;
      }
      pq.poll();
    }
    return -1;
  }
}

/**
 * Your NumberContainers object will be instantiated and called as such: NumberContainers obj = new
 * NumberContainers(); obj.change(index,number); int param_2 = obj.find(number);
 */
