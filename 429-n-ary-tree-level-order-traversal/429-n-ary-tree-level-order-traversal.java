/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            int s=q.size();
            List<Integer> level=new ArrayList<>();
            if(s>0){
            for(int i=0;i<s;i++){
                Node tmp=q.poll();
                level.add(tmp.val);
                for(Node child : tmp.children){
                    q.offer(child);
                }
            
            }
            }
            res.add(level);
            
           
        }
        return res;
        
    }
}