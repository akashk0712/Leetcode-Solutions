class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Create a hash map to store the frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0; // Maximum frequency
        int result = 0; // Total frequencies of elements with maximum frequency

        // Calculate the frequency of each element
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }

        // Sum up the occurrences of elements that appear maxFreq times
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result += entry.getValue();
            }
        }

        return result;
    }
}