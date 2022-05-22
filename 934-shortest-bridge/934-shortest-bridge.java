class Solution {
    //first we identify an island by using dfs and will add all it's node to the queue
    //second we will use this queue in BFS to find the orther
    //since bfs ensures min distance it'll find the shortest bridge between one island to another island.
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int[][] grid,Queue<pair> q,boolean vis[][],int i,int j){
        q.add(new pair(i,j));
        vis[i][j]=true;
        for(int dir[]:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 ||y<0 ||x>=grid.length||y>=grid[0].length||vis[x][y]==true ||grid[x][y]==0)
                continue;
            dfs(grid,q,vis,x,y);
        }
        
    }
    public int shortestBridge(int[][] grid) {
        Queue<pair> q=new ArrayDeque<>();
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        boolean flag=false;
        for(int i=0;i<grid.length && !flag;i++){
            for(int j=0;j<grid[0].length && !flag;j++){
                if(grid[i][j]==1){
                    dfs(grid,q,vis,i,j);
                   flag=true;
                }
            }
        }
        int level=0;
        //use bfs to find the next island
        while(q.size()>0){
            int size=q.size();
            while(size-->0){// this while loop itterate at each level i.e., measure distance at each level
                pair temp=q.remove();
                int r=temp.row;
                int c=temp.col;
                for(int dir[]:dirs){
                    int x=dir[0]+r;
                    int y=dir[1]+c;
                    if(x<0 ||y<0 ||x>=grid.length||y>=grid[0].length||vis[x][y]==true)
                        continue;
                    if(grid[x][y]==1)
                        return level;
                    q.add(new pair(x,y));
                    vis[x][y]=true;
                }
            }
            level++;
        }
        return -1;
    }
}