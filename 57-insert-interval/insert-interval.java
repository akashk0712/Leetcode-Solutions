class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] result = new int[n + 1][2];
        int i = 0;
        int index = 0;

        // Add intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result[index++] = intervals[i++]; 
    }
    while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result[index++] = newInterval;

        // Add remaining intervals
        while (i < n) {
            result[index++] = intervals[i++];
        }

        // Resize the result array to remove any unused slots
        return Arrays.copyOf(result, index);
    }
}