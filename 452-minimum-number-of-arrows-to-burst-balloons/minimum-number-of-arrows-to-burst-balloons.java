class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // Sort by end points
        
        int count = 1; // At least one arrow needed
        int x = points[0][1]; // Initialize the end point
        
        for(int i = 1; i < points.length; i++) {
            if (points[i][0] > x) { // If the current balloon starts after the previous end point
                count++; // Increase arrow count
                x = points[i][1]; // Update the end point
            }
        }
        
        return count;
    }
}