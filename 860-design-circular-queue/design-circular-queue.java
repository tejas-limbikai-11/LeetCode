class MyCircularQueue {
    int[] q;
    int front = 0, rear = 0, size = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        Arrays.fill(q, -1);
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;

        if(isEmpty()) {
            front = rear = 0;
            q[rear] = value;
            size++;
            return true;
        }

        rear++;
        size++;
        rear = rear % q.length;
        q[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        q[front] = -1;
        front++;
        size--;
        front = front % q.length;
        return true;
    }
    
    public int Front() {
        return q[front];
    }
    
    public int Rear() {
        return q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */