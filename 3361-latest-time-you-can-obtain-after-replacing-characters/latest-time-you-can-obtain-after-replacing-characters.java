class Solution {
    public String findLatestTime(String s) {
        char times[] = s.toCharArray();
        if(times[0] == '?') {
            if(times[1] <= '1' || times[1] == '?') times[0] = '1';
            else times[0] = '0'; 
        }  
        if(times[1] == '?') {
            if(times[0] == '0') times[1] = '9';
            else times[1] = '1';
        }
        if(times[3] == '?') {
            times[3] = '5';
        }
        if(times[4] == '?') {
            times[4] = '9';
        }
        return new String(times);
    }
}