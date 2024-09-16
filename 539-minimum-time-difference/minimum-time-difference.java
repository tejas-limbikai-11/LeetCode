class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for(String time: timePoints) {
            minutes.add(convertToMinutes(time));
        }
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<minutes.size(); i++) {
            int diff = minutes.get(i) - minutes.get(i-1);
            minDiff = Math.min(minDiff, Math.min(diff, 1440 - diff));
        }   
        minDiff = Math.min(minDiff, 1440 - (minutes.get(minutes.size() - 1) - minutes.get(0)));
        return minDiff;
    }

    public int convertToMinutes(String time) {
        String[] parts = time.split(":");
        Integer hours = Integer.parseInt(parts[0]);
        Integer minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}