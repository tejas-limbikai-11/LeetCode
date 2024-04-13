class Solution {
    public int[] getNSR(int height[]) {
        Stack<Integer> s = new Stack<>();
        int n = height.length;
        int nsr[] = new int[n];

        for(int i=height.length-1; i>=0; i--) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if(s.isEmpty()) nsr[i] = height.length;
            else nsr[i] = s.peek();

            s.push(i);
        }
        return nsr;
    }

    public int[] getNSL(int height[]) {
       Stack<Integer> s = new Stack<>();
        int n = height.length;
        int nsl[] = new int[n];

        for(int i=0; i<height.length; i++) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if(s.isEmpty()) nsl[i] = -1;
            else nsl[i] = s.peek();

            s.push(i);
        }
        return nsl; 
    }

    public int findMaxArea(int height[]) {
        //height -> height[i];
        //width -> NSR[i] - NSL[i] - 1;

        int NSR[] = getNSR(height);
        int NSL[] = getNSL(height);

        int n = height.length;
        int width[] = new int[n];

        for(int i=0; i<n; i++) {
            width[i] = NSR[i] - NSL[i] - 1;
        }

        int maxArea = 0;

        for(int i=0; i<n; i++) {
            int area = height[i] * width[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int height[] = new int[n];

        for(int i=0; i<n; i++) {
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        int maxArea = findMaxArea(height);

        for(int row = 1; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(matrix[row][col] == '0') {
                    height[col] = 0;
                }
                else height[col] += 1;
            }
            maxArea = Math.max(maxArea, findMaxArea(height));
        }

        return maxArea;
    }
}