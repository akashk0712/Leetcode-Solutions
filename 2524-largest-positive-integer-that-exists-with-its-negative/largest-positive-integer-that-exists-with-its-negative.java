class Solution {
    public int findMaxK(int[] nums) {
        int maxK = -1;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        for(int num : numSet){
            if(numSet.contains(-num)){
                maxK = Math.max(maxK, num);
            }
        }
        return maxK;
    }
}