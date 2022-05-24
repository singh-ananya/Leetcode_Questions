class Solution {
    //It is based on the number of connected components in a graph
    int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public void connectedComponents(int[][] grid,int i,int j,boolean vis[][]){
        vis[i][j]=true;
        for(int dir[]:dirs){
            int x=dir[0]+i;
            int y=dir[1]+j;
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && vis[x][y]==false){
               connectedComponents(grid,x,y,vis); 
            }
        }
    }
    public int isIsland(int[][] grid){
        int cnt=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    cnt++;
                    connectedComponents(grid,i,j,vis);
                    
                }
            }
        }
        return cnt;
    }
    public int minDays(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(isIsland(grid)==0 || isIsland(grid)>1) //if there are already 0 or more than 1 connected components then we return 0 coz graph is already disconnected;
            return 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(isIsland(grid)==0 || isIsland(grid)>1) //if there are more than 1 comp or 0 then return 1
                        return 1;
                    grid[i][j]=1;//backtrack
                }
            }
        }
        //otherwise return 2
        //for details see hints given in ques.
        return 2;
        
    }
}