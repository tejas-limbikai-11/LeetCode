class Solution {
    public String longestWord(String[] words) {
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        return ans;
    }

    class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;  
    }

    public Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public boolean search(String key) {
        Node curr = root;
        for(int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    public String ans = "";

    public void longestWord(Node root, StringBuilder temp) {
        if(root == null) return;

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].endOfWord == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);    // recursion
                temp.deleteCharAt(temp.length() - 1);   // backtracking
            }
        }
    }
}