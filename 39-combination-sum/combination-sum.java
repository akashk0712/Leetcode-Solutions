class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        //sort the array to avoid duplicate combinations

        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if(target == 0) {
            result.add(new ArrayList<>(current)); //found a valid combination
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break; //skip if the current candidate is too large
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i); //recurse with reduced target

            current.remove(current.size() - 1); //backtrack
        }
    }
}