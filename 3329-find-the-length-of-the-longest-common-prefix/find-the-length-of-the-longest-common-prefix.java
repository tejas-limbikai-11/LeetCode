class Solution {
    public class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }

    public TrieNode getNode() {
        TrieNode newNode = new TrieNode();
        
        for(int i=0; i<10; i++) {
            newNode.children[i] = null;
        }
        return newNode;
    }

    public void insert(TrieNode root, String word) {
        TrieNode crawler = root;
        for(char ch: word.toCharArray()) {
            int idx = ch - '0';
            if(crawler.children[idx] == null) {
                crawler.children[idx] = getNode();
            }
            crawler = crawler.children[idx];
        }
    }

    public int DFS(TrieNode root, String word) {
        TrieNode crawler = root;
        int count = 0;

        for(char ch: word.toCharArray()) {
            int idx = ch - '0';
            if(crawler.children[idx] == null) {
                return count;
            }
            count++;
            crawler = crawler.children[idx];
        }
        return count;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getNode();
        int result = 0;

        for(int num: arr1) {
            insert(root, String.valueOf(num));
        }

        for(int num: arr2) {
            result = Math.max(result, DFS(root, String.valueOf(num)));
        }

        return result;
    }
}