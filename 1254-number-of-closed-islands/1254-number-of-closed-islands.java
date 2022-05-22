class Solution {
    int [][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean dfs(int[][] grid,int i,int j){
        if(i<0 ||i>=grid.length||j<0 || j>=grid[0].length){
            return false;
        }
        if(grid[i][j]==1)
            return true;
        grid[i][j]=1;
        boolean ans = true;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            ans=dfs(grid,x,y) && ans;
            
        }
        return ans;
        
    }
    public int closedIsland(int[][] grid) {
        int count=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==0){
                        if(dfs(grid,i,j))
                            count++;
                    }
                }
            }
        return count;
    }
}