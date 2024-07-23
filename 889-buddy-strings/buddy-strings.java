class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        if(s.equals(goal)) {
            int[] arr = new int[26];
            for(char ch : s.toCharArray()) {
                arr[ch - 'a']++;
                if(arr[ch - 'a'] > 1) return true;
            }
            return false;
        }

        List<Integer> indices = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                indices.add(i);
            }
        }

        if(indices.size() != 2) return false;

        char sArray[] = s.toCharArray();
        char temp = sArray[indices.get(0)];
        sArray[indices.get(0)] = sArray[indices.get(1)];
        sArray[indices.get(1)] = temp;

        return new String(sArray).equals(goal);
    }
}