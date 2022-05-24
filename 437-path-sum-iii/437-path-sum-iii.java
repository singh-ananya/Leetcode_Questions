class Solution {
    
    List<Integer> path = new ArrayList<>();
    int paths = 0;
    
    void dfs(TreeNode node, int sum) {
        
        if(node == null)
            return;
        
        path.add(node.val);
        
        dfs(node.left, sum);
        dfs(node.right, sum);
        
        int temp = 0;
        for(int i=path.size()-1; i>=0; i--) {
            
            temp += path.get(i);
            
            if(temp == sum)
                paths++;
        }
        
        path.remove(path.size()-1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        
        dfs(root, targetSum);
        
        return paths;
    }
}