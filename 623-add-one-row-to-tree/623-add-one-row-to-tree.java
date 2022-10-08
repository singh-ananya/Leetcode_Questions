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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null){
            TreeNode n=new TreeNode(val);
            return n;
        }
        if(depth==1){
            TreeNode n=new TreeNode(val);
            n.left=root;
            return n;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        int cdepth=1;
        q.add(root);
        while(q.size()>0){
           int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode tmp=q.remove();
                //q.remove();
                if(cdepth==depth-1){
                    TreeNode leftnode=new TreeNode(val);
                    leftnode.left=tmp.left;
                    tmp.left=leftnode;
                    TreeNode rightnode=new TreeNode(val);
                    rightnode.right=tmp.right;
                    tmp.right=rightnode;
                }
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            cdepth++;
        }
        return root;
        
    }
}