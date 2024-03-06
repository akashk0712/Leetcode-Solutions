class Solution {
    public int numIdenticalPairs(int[] nums) {
         Map<Integer, Integer> countMap = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int count : countMap.values()) {
            ans += count * (count - 1) / 2;
        }
        return ans;
    }
}