class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        boolean[] cooked = new boolean[n];
        int count = n;

        while (count-- > 0) {
            for (int i = 0; i < n; i++) {
                if (cooked[i]) continue;

                boolean canMake = true;
                for (String str : ingredients.get(i)) {
                    if (!set.contains(str)) {
                        canMake = false;
                        break;
                    }
                }
                if (canMake) {
                    result.add(recipes[i]);
                    set.add(recipes[i]);
                    cooked[i] = true;
                }
            }
        }
        return result;
    }
}