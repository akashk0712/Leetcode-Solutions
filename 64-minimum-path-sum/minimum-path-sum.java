class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize the first row and first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Compute the minimum sum for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // Return the minimum sum for the bottom right cell
        return grid[m - 1][n - 1];
    }
}