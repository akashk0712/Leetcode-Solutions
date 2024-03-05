class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] memo = new int[n];
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            memo[i] = triangle.get(n - 1).get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                memo[col] = triangle.get(row).get(col) + Math.min(memo[col], memo[col + 1]);
            }
        }
        return memo[0];
    }
}