class Solution {
    public String reverseWords(String s) {
         if (s == null) return null;

        char[] str = s.toCharArray();
        int start = 0, end = str.length - 1;

        while(start <= end && str[start] == ' ') {
            start++;
        }

        while(end >= 0 && str[end] == ' ') {
            end--;
        }

        if(start > end) return "";

        int i = start;

        while(i <= end) {
            if(str[i] != ' ') {
                int j = i+1;
                while(j <= end && str[j] != ' ') {
                    j++;
                }
                reverse(str, i, j-1);
                i = j;
            }
            else {
                if(i > start && str[i - 1] == ' ') {
                    int j = i;
                    while(j <= end - 1) {
                        str[j] = str[j+1];
                        j++;
                    }
                    end--;
                }
                else i++;
            }

        }
        reverse(str, start, end);

        return new String(str, start, end - start + 1);
    }

    public void reverse(char[] str, int begin, int end) {
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}