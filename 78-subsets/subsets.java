class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       {
        Set<List<Integer>> resultSet = new HashSet<>();
        resultSet.add(new ArrayList<>()); // Empty subset
        for (int i = 0; i < nums.length; i++) {
            int N = resultSet.size();
            List<List<Integer>> temp = new ArrayList<>(resultSet);
            for (List<Integer> existingSubset : temp) {
                List<Integer> newSubset = new ArrayList<>(existingSubset);
                newSubset.add(nums[i]);
                resultSet.add(newSubset);
            }
        }
        return new ArrayList<>(resultSet);
    } 
    }
}