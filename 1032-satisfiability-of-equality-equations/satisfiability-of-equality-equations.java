class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] rank = new int[26];
        int[] parent = new int[26];
        for(int i=0; i<26; i++) {
            parent[i] = i;
        }

        for(String eq: equations) {
            
            if(eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(x, y, parent, rank);
            }
        }

        for(String eq: equations) {
            if(eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                int xParent = find(x, parent);
                int yParent = find(y, parent);

                if(xParent == yParent) return false;
            }

        }
        return true;
    }

    public int find(int i, int[] parent) {
        if(i == parent[i]) return parent[i];

        return parent[i] = find(parent[i], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if(xParent == yParent) return;

        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        else if(rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}