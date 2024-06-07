class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder();

        String words[] = sentence.split(" ");
        for(String word: words) {
            result.append(findRoot(word, set)).append(" ");
        }
        
        return result.toString().trim();  //remove trailing space - trim()
    }
    
    public String findRoot(String word, HashSet<String> set) {
        for(int i=1; i<=word.length(); i++) {
            String root = word.substring(0, i);
            if(set.contains(root)) return root;
        }
        return word;
    }
}