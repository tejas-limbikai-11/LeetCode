class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int n = s1.length;
        int m = s2.length;

        if(n < m) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        Deque<String> dq1 = new LinkedList<>(Arrays.asList(s1));
        Deque<String> dq2 = new LinkedList<>(Arrays.asList(s2));

        while(!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekFirst().equals(dq2.peekFirst())) {
            dq1.pollFirst();
            dq2.pollFirst();
        }

        while(!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }

        return dq2.isEmpty();
    }
}