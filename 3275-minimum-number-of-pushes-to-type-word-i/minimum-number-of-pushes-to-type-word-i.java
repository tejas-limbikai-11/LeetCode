class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        
        int count = 1;
        int charAssigned = 0;

        for(char ch: word.toCharArray()) {
            map.put(ch, count);
            charAssigned++; 

            if(charAssigned == 8) {
                count++;
                charAssigned = 0;
            }
        }

        int result = 0;
        for(char ch: word.toCharArray()) {
            result += map.get(ch);
        }
        return result;
    }
}