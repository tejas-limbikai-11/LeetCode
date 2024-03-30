class Solution {
    static class Node {
        Node children[] = new Node[26];
        int freq = 0;
        boolean isEndOfWord = false;

        public Node() {
            for(int i=0; i<children.length; i++) {
                children[i] = null;
            }
        }
    }

    public Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.freq++;
        }
        curr.isEndOfWord = true;
    }

    public String longestCommonPrefixFunction() {
        Node curr = root;
        String prefix = "";
        while(curr != null) {
            int singleChildIdx = -1;
            for(int i=0; i<26; i++) {
                if(curr.children[i] != null) {
                    if(singleChildIdx == -1) {
                        singleChildIdx = i;
                    } 
                    else return prefix;
                }
            }
            if(singleChildIdx != -1) {
                prefix += (char) (singleChildIdx + 'a');
                curr = curr.children[singleChildIdx];
                if(curr.isEndOfWord) return prefix;
            } 
            else break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        for(String str : strs) {
            if(str.equals("")) return "";
        }

        root = new Node();
        for(int i=0; i<strs.length; i++) {
            insert(strs[i]);
        }
        return longestCommonPrefixFunction();
    }
}