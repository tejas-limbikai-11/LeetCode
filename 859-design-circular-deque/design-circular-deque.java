class MyCircularDeque {

    Deque<Integer> dq = new ArrayDeque<>();
    int cap;

    public MyCircularDeque(int k) {
        this.cap = k;   
    }
    
    public boolean insertFront(int value) {
        if(dq.size() < cap) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(dq.size() < cap) {
            dq.addLast(value);
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(dq.size() > 0) {
            dq.removeFirst();
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(dq.size() > 0) {
            dq.removeLast();
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return dq.getFirst();
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return dq.getLast();
    }
    
    public boolean isEmpty() {
        return dq.size() == 0;   
    }
    
    public boolean isFull() {
        return dq.size() == cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */