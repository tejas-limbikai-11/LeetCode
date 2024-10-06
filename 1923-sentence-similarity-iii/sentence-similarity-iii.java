class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int n = s1.length;
        int m = s2.length;

        if(n < m) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int i = 0, j = n-1;
        int k = 0, l = m-1;

        while(i < n && k < m && s1[i].equals(s2[k])) {
            i++;
            k++;
        }
        while(l >= k && s1[j].equals(s2[l])) {
            j--;
            l--;
        }
    
        return l < k;
    }
}