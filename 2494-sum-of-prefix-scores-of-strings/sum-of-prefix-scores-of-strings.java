class Solution {
    public class TrieNode {
        int countPrefix;
        TrieNode[] children = new TrieNode[26];
    }

    public TrieNode getNode() {
        TrieNode newNode = new TrieNode();
        newNode.countPrefix = 0;

        for(int i=0; i<26; i++) {
            newNode.children[i] = null;
        }
        return newNode;
    }

    public void insert(TrieNode root, String word) {
        TrieNode crawler = root;

        for(char ch: word.toCharArray()) {
            if(crawler.children[ch - 'a'] == null) {
                crawler.children[ch - 'a'] = getNode();
            }
            crawler.children[ch - 'a'].countPrefix += 1;
            crawler = crawler.children[ch - 'a'];
        }
    }

    public int getScore(TrieNode root, String word) {
        TrieNode crawler = root;
        int score = 0;

        for(char ch: word.toCharArray()) {
            score += crawler.children[ch - 'a'].countPrefix;

            crawler = crawler.children[ch - 'a'];
        }
        return score;
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;

        TrieNode root = getNode();

        for(String word: words) {
            insert(root, word);
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = getScore(root, words[i]);
        }

        return result;
    }
}