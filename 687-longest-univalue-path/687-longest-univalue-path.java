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
    int longp=0;
    public int longestUnivaluePath(TreeNode root) {
       if(root==null) 
           return longp;
        dfs(root);
        return longp;
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        int l=0;
        int r=0;
        if(root.left!=null && root.val==root.left.val)
            l=left+1;
        if(root.right!=null && root.val==root.right.val)
            r=right+1;
        longp=Math.max(longp,l+r);
        return Math.max(l,r);
    }
}