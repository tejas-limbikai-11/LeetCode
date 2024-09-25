class Solution {
    private int m;
    private int n;
    private List<String> result;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public class TrieNode {
        boolean endOfWord;
        String word;
        TrieNode[] children = new TrieNode[26];
    }

    public TrieNode getNode() {
        TrieNode newNode = new TrieNode();
        newNode.endOfWord = false;
        newNode.word = "";

        for(int i=0; i<26; i++) {
            newNode.children[i] = null;
        }
        return newNode;
    }   

    public void insert(TrieNode root, String word) {
        TrieNode crawler = root;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if(crawler.children[ch - 'a'] == null) {
                crawler.children[ch - 'a'] = getNode();
            }
            crawler = crawler.children[ch - 'a'];
        }

        crawler.endOfWord = true;
        crawler.word = word;
    }

    public void DFS(char[][] board, int i, int j, TrieNode root) {
        if(i < 0 || i >= m || j < 0 || j >= n ) {
            return;
        }

        if(board[i][j] == '$' || root.children[board[i][j] - 'a'] == null) {
            return;
        }

        root = root.children[board[i][j] - 'a'];

        if(root.endOfWord == true) {
            result.add(root.word);
            root.endOfWord = false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] d: directions) {
            int newI = i + d[0];
            int newJ = j + d[1];

            DFS(board, newI, newJ, root);
        }
        board[i][j] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        result = new ArrayList<>();

        TrieNode root = getNode();

        for(String word: words) {
            insert(root, word);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(root.children[board[i][j] - 'a'] != null) {
                    DFS(board, i, j, root);
                }
            }
        }
        return result;
    }
}