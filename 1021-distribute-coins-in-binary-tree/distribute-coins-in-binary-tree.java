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
    // This problem can be solved using DFS.
    // The idea is to find the minimum number of moves needed to make sure each node has exactly one coin.
    // We can keep track of the surplus or deficit of coins at each node as we traverse the tree.
    // The surplus at the root is the total number of moves needed.
    
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    
    // Performs a depth first search on the tree, keeping track of the surplus of coins at each node
    public int dfs(TreeNode node) {
        if (node == null) return 0;
        
        // Get the surplus of coins for the left and right subtrees
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        // Add the number of moves needed to correct the surplus at this node to the total
        moves += Math.abs(left) + Math.abs(right);
        
        // Return the surplus at this node
        return node.val + left + right - 1;
    }
}