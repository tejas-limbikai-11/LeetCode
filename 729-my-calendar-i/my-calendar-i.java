class MyCalendar {
    Set<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
    }
    
    public boolean book(int start, int end) {
        for(int[] arr: set) {
            int currStart = arr[0];
            int currEnd = arr[1];
            if(start < currEnd && end > currStart) return false;
        }
        set.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */