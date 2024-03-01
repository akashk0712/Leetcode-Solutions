class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
    }
    int left = findLeftmost(nums, target);
        if (left == -1) {
            return result; // Target not found
        }

        // Find the rightmost occurrence of the target
        int right = findRightmost(nums, target);

        result[0] = left;
        result[1] = right;
        return result;
    }

    private static int findLeftmost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1; // Move left to find leftmost occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1; // Target not found
    }

    private static int findRightmost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // Move right to find rightmost occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1; // Target not found
    }
}