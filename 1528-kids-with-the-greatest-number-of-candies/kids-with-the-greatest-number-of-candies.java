class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list =  new ArrayList<Boolean>();
        for(int i=0; i<candies.length; i++){
            int largest = largestNum(candies);
            if((candies[i]+ extraCandies) >= largest){
                list.add(true);
            } else{
                list.add(false);
            }
        }
        return list;
    }

    public static int largestNum(int[] candies){
        int largest = 0;
        for(int i=0; i<candies.length; i++){
            if(largest < candies[i]){
                largest = candies[i];
            }
        }
        return largest;
    }
}