class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];
        int left = 0;
        int right = n-1;

        int strongest[] = new int[k];
        int i=0;
        while(i < k){
            if(Math.abs(arr[left]-m) > Math.abs(arr[right]-m)){
                strongest[i] = arr[left];
                left++;
            } else{
                strongest[i] = arr[right];
                right--;
            }
            i++;
        }
        return strongest;
    }
}