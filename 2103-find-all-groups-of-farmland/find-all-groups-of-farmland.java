class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int row2, col2;

    private void dfs(int[][] land, int x, int y) {
        if(x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] != 1) {
            return;
        }
        land[x][y] = 0;
        row2 = Math.max(row2, x); 
        col2 = Math.max(col2, y);
        for (int[] direction : directions) {
            int newX = x + direction[0], newY = y + direction[1];
            dfs(land, newX, newY);
        }
    }
    
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();

        for (int row1 = 0; row1 < land.length; row1++) {
            for (int col1 = 0; col1 < land[0].length; col1++) {
                if (land[row1][col1] == 1) {
                    row2 = 0; col2 = 0;
                    dfs(land, row1, col1);
                    int[] arr = new int[] {row1, col1, row2, col2};
                    ans.add(arr);
                }
            }
        }
        
        return ans.stream().toArray(int[][] :: new);
    }
}
