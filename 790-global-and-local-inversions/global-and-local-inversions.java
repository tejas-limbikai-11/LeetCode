class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int local = localInversions(nums);
        int global = globalInversions(nums, n);
        return local == global;
    }

    public int localInversions(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) {
                count++;
            }
        }
        return count;
    }

    public int globalInversions(int[] a, int n) {
        return mergeSort(a, 0, n - 1);
    }

    public int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low;      
        int right = mid + 1;

        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); 
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; 
    }

    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);  
        cnt += mergeSort(arr, mid + 1, high); 
        cnt += merge(arr, low, mid, high);  
        return cnt;
    }
}
