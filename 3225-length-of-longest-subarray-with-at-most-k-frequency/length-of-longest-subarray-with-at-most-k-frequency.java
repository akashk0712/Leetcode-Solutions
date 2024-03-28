class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
          // Map to store the frequency of each number in the current subarray
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0; // To store the length of the longest subarray

        // Use the two-pointer technique
        for (int start = 0, end = 0; end < nums.length; ++end) {
            // Increase the frequency of the current number
            frequencyMap.merge(nums[end], 1, Integer::sum);

            // If the frequency of the current number exceeds k, shrink the window from the left 
            while (frequencyMap.get(nums[end]) > k) {
                frequencyMap.merge(nums[start], -1, Integer::sum);
                start++; // Move the start index to the right
            }

            // Calculate the length of the current subarray and update maxLength if it is bigger
            maxLength = Math.max(maxLength, end - start + 1);
        }
      
        // Return the maximum length found
        return maxLength;
    }
}