class CustomStack {
    int[] stack;
    int idx;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        idx = 0;
    }
    
    public void push(int x) {
        if(idx == stack.length) return;
        stack[idx++] = x;
    }
    
    public int pop() {
        if(idx == 0) return -1;
        return stack[--idx];
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<k && i<stack.length; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */