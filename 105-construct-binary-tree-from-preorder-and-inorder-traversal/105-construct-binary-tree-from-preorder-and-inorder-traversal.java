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
    public TreeNode build(int pre[],int psi,int pei,int in[],int isi,int iei){
        if(psi>pei)
            return null;
        if(psi==pei)
            return new TreeNode(pre[psi]);
        TreeNode root=new TreeNode(pre[psi]);
        int root_idx=isi;
        int cnt=0;
        while(in[root_idx]!=root.val){
            root_idx++;
            cnt++;
        }
        
        root.left=build(pre,psi+1,psi+cnt,in,isi,root_idx-1);
        root.right=build(pre,psi+cnt+1,pei,in,root_idx+1,iei);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
}