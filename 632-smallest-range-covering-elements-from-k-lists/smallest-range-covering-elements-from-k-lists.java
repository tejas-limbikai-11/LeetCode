class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k  = nums.size();
        int[] arr = new int[k];
        int[] resultRange = {-1000000, 1000000};

        while(true) {
            int minEl = Integer.MAX_VALUE;
            int maxEl = Integer.MIN_VALUE;
            int minElListIdx = 0;

            for(int i=0; i<k; i++) {
                int listIdx = i;
                int elIdx = arr[i];
                int element = nums.get(listIdx).get(elIdx);

                if(element < minEl) {
                    minEl = element;
                    minElListIdx = listIdx;
                }

                maxEl = Math.max(maxEl, element);
            }

            if(maxEl - minEl < resultRange[1] - resultRange[0]) {
                resultRange[0] = minEl;
                resultRange[1] = maxEl;
            }

            int nextIdx = arr[minElListIdx] + 1;
            if(nextIdx >= nums.get(minElListIdx).size()) {
                break;
            }
            arr[minElListIdx] = nextIdx;
        }

        return resultRange;
    }
}