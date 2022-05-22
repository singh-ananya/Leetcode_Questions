class Solution {
    public boolean dfs(int[][] grid1, int[][] grid2,int i,int j,int n,int m){
        boolean ans=true;
        if(grid1[i][j]!=grid2[i][j]){
            ans=false;
        }
        grid2[i][j]=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        for(int dir[]:dirs){
            int x=dir[0]+i;
            int y=dir[1]+j;
            if(x>=0 && x<n && y>=0 && y<m && grid2[x][y]==1){
                ans=dfs(grid1,grid2,x,y,n,m) && ans;
            }
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m=grid1[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1){
                    boolean issub=dfs(grid1,grid2,i,j,n,m);
                    if(issub)
                        ans++;
                }
            }
        }
        return ans;
    }
}