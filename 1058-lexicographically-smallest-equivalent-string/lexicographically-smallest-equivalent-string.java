class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int[] parent = new int[26];
        for(int i=0; i<26; i++) {
            parent[i] = i;
        }

        for(int i=0; i<n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            union(ch1 - 'a', ch2 - 'a', parent);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: baseStr.toCharArray()) {
            sb.append((char) (find(ch - 'a', parent) + 'a'));
        }

        return sb.toString();
    }

    public int find(int i, int[] parent) {
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }

    public void union(int x, int y, int[] parent){ 
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if(xParent == yParent) return;

        if(xParent < yParent) {
            parent[yParent] = xParent;
        }
        else {
            parent[xParent] = yParent;
        }
    }
}