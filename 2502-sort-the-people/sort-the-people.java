class Solution {
    class Pair implements Comparable<Pair>{
        int height;
        String name;

        public Pair(int h, String n) {
            this.height = h;
            this.name = n;
        }

        @Override
        public int compareTo(Pair other) {
            return other.height - this.height; 
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Pair[] people = new Pair[heights.length];

        for(int i=0; i<heights.length; i++) {
            people[i] = new Pair(heights[i], names[i]);
        }

        Arrays.sort(people);

        String[] result = new String[heights.length];

        for(int i=0; i<heights.length; i++) {
            result[i] = people[i].name;
        }
        return result;
    }
}