class Solution {
    public boolean dfs(int[][] grid,int i,int j){
        if(i<0 ||i>=grid.length||j<0 || j>=grid[0].length){
            return false;
        }
        if(grid[i][j]==1)
            return true;
        grid[i][j]=1;
        boolean a=dfs(grid,i+1,j);
        boolean b=dfs(grid,i-1,j);
        boolean c=dfs(grid,i,j+1);
        boolean d=dfs(grid,i,j-1);
        return a && b && c && d;
        
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