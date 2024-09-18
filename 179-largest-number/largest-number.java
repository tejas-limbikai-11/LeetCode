class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, (a,b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        
        if(numbers[0].equals("0")) return "0";

        for(String str: numbers) {
            sb.append(str);
        }
        return sb.toString();
    }
}