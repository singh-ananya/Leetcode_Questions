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
    List<Integer> ans=new ArrayList<>();
    int cnt=0;
    public void helper(TreeNode root, int sum){
        if(root==null)
            return;
        ans.add(root.val);
        helper(root.left,sum);
        helper(root.right,sum);
        int tmp=0;
        for(int i=ans.size()-1;i>=0;i--){
            tmp+=ans.get(i);
            if(sum==tmp){
                cnt++;
            }
        }
        ans.remove(ans.size()-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return cnt;
        helper(root,targetSum);
        return cnt;
        
    }
}