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
    public void rec(TreeNode root,int level,List<Integer> ans){
        if(root==null)
        return;
        if(ans.size()==level){
            ans.add(root.val);
        }
        
        rec(root.right,level+1,ans);
        rec(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        rec(root,0,ans);
        return ans;
        
    }
}