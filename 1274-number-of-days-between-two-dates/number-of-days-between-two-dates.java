class Solution {
    public int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(from1971(date1) - from1971(date2));
    }

    public int from1971(String date) {
        String parts[] = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int count = day;
        for(int i=1971; i<year; i++) {
            count += (isLeapYear(i)) ? 366: 365;
        }
        for(int i=0; i<month-1; i++) {
            count += months[i];
        }
        if(month > 2 && isLeapYear(year)) count += 1;
        return count;
    }

    public boolean isLeapYear(Integer year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}