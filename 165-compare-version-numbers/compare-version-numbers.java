class Solution {
    public int compareVersion(String version1, String version2) {
        List<String> v1 = getTokens(version1);
        List<String> v2 = getTokens(version2);

        int m = v1.size();
        int n = v2.size();
        int i = 0;

        while(i < m || i < n) {
            int a = i < m ? Integer.parseInt(v1.get(i)) : 0;
            int b = i < n ? Integer.parseInt(v2.get(i)) : 0;

            if(a > b) return 1;
            else if(b > a) return -1;
            else i++;
        }
        return 0;
    }

    public List<String> getTokens(String version) {
        String splitTokens[] = version.split("\\.");
        List<String> tokens = new ArrayList<>();
        for(String splitToken: splitTokens) {
            tokens.add(splitToken);
        }
        return tokens;
    }
}