class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Create an array to store the frequency of each task
        int[] taskFrequency = new int[26];
        for (char task : tasks) {
            taskFrequency[task - 'A']++;
        }

        // Sort the task frequencies in descending order
        Arrays.sort(taskFrequency);

        // Get the maximum occurrence of any task
        int maxOccurrence = taskFrequency[25];

        // Calculate the minimum number of intervals required
        int idleSlots = (maxOccurrence - 1) * n;
        for (int i = 24; i >= 0 && taskFrequency[i] > 0; i--) {
            idleSlots -= Math.min(maxOccurrence - 1, taskFrequency[i]);
        }

        // The total intervals needed is the sum of tasks and idle slots
        return tasks.length + Math.max(0, idleSlots);
    }
}
