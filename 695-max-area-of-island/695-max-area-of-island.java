class Solution {
    public int dfs(int[][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        grid[i][j]=0;
        int size=0;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1)
                size+=dfs(grid,x,y);
        }
        return size+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]==1){
                  int size=dfs(grid,i,j);
                  ans=Math.max(ans,size);
              }  
            }
        }
        return ans;
    }
}