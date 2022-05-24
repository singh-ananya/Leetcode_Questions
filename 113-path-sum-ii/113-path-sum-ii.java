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
    //new ArrayList<>(list)creates a new list, containing all the elements in list. This is required, since at the end of the function you are calling list.remove(list.size()-1);, you are thus modifying the list variable.
    List<List<Integer>> ans=new ArrayList<>();
    public void helper(TreeNode root,List<Integer> list,int targetSum){
        if(root==null)
            return;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0){
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1); //removes the last element either answer is being reached or not
            return;
        }
        if(root.left!=null){
            helper(root.left,list,targetSum-root.val);
        }
        if(root.right!=null){
            helper(root.right,list,targetSum-root.val);
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return ans;
        List<Integer> list=new ArrayList<>();
        helper(root,list,targetSum);
        return ans;
        
        
    }
}