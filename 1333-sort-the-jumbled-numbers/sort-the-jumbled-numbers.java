class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            list.add(new int[] {convert(nums[i], mapping), i});
        }
        Collections.sort(list, (a, b) -> {
            int num1 = a[0];
            int num2 = b[0];
            int idx1 = a[1];
            int idx2 = b[1];
            return (num1 == num2) ? idx1 - idx2 : num1 - num2;
        });

        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int idx = list.get(i)[1];
            ans[i] = nums[idx];
        }
        return ans;
    }

    int value = 1;

    public int convert(int num, int[] mapping) {
        if(num == 0) return mapping[0];
        
        int newNum = 0;
        int value = 1;
        while(num > 0) {
            int idx = num % 10;
            newNum += (value * mapping[idx]);
            num /= 10;
            value *= 10;
        }
        return newNum;
    }
}