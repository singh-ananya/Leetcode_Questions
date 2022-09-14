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
    int res=0;
    public int pseudoPalindromicPaths (TreeNode root) {
       Set<Integer> set=new HashSet<>();
        dfs(root,set);
        return res;
    }
    public void dfs(TreeNode root,Set<Integer> set){
        if(root==null)
            return;
        if(set.contains(root.val))
            set.remove(root.val);
        else
            set.add(root.val);
        if(root.left==null && root.right==null){
            if(set.size()==1 || set.isEmpty())
                res++;
        }
        dfs(root.left,set);
        dfs(root.right,set);
        if(set.contains(root.val))
            set.remove(root.val);
        else
            set.add(root.val);
        
    }
}