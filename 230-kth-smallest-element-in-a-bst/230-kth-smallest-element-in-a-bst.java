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
    //the inorder traversal of a BST is sorted is ascending order
    List<TreeNode> inorder=new ArrayList<>();
    public void irorderTraversal(TreeNode root){
        if(root==null)
            return;
        irorderTraversal(root.left);
        inorder.add(root);
        irorderTraversal(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
       if(root!=null){
           irorderTraversal(root);
       } 
        int t=inorder.get(k-1).val;
        return t;
    }
}