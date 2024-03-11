class Solution {
    public String customSortString(String order, String s) {
         // Create a frequency map for characters in s
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Create the result string
        StringBuilder result = new StringBuilder();

        // Append characters from order in the desired order
        for (char c : order.toCharArray()) {
            if (freqMap.containsKey(c)) {
                int count = freqMap.get(c);
                while (count > 0) {
                    result.append(c);
                    count--;
                }
                freqMap.remove(c);
            }
        }

        // Append remaining characters from s
        for (char c : freqMap.keySet()) {
            int count = freqMap.get(c);
            while (count > 0) {
                result.append(c);
                count--;
            }
        }

        return result.toString();
    }
}