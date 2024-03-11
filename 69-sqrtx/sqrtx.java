class Solution {
    public int mySqrt(int x) {
        // Base case: If x is 0 or 1, the square root is x itself
        if (x == 0 || x == 1) {
            return x;
        }

        // Initialize variables for binary search
        long left = 1; // Start from 1 (since sqrt(0) = 0)
        long right = x; // Upper bound for binary search

        // Perform binary search to find the square root
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid; // Found exact square root
            } else if (square < x) {
                left = mid + 1; // Adjust left boundary
            } else {
                right = mid - 1; // Adjust right boundary
            }
        }

        // Return the floor value of the square root
        return (int) right;
    }
}