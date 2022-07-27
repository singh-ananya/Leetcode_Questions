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
    //static TreeNode prev=null; 
    public void flatten(TreeNode root) {
       if(root==null)
           return;
        TreeNode tmp=root;
        while(tmp!=null){
            if(tmp.left!=null){
                TreeNode leftside=tmp.left;
                while(leftside.right!=null)
                    leftside=leftside.right;
                leftside.right=tmp.right;
                tmp.right=tmp.left;
                tmp.left=null;
            }
            tmp=tmp.right;
        }
    }
}