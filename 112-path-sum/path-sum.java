/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false; // Base case: Empty tree
        }

        // If the current node is a leaf, check if its value equals the remaining sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recurse on left and right subtrees with updated targetSum
        boolean leftPath = hasPathSum(root.left, targetSum - root.val);
        boolean rightPath = hasPathSum(root.right, targetSum - root.val);

        // Return true if either left or right subtree has a valid path
        return leftPath || rightPath;
    }
}