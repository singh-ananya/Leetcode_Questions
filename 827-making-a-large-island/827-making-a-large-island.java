class Solution {
    int arcnt;
    Map<Integer,Integer> mp;
    int index=2;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        mp=new HashMap<>();
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    arcnt=0;
                    dfs(i,j,grid);
                    res=Math.max(res,arcnt);
                    mp.put(index++,arcnt);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    res=Math.max(res,connect(i,j,grid));
                }
            }
        }
        return res;
        
    }
    public int connect(int x,int y,int[][] grid){
        int tot=0;
        
        Set<Integer> set = new HashSet<>();
        for(int[] dir:dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if(i>=0 && j>=0 && i<grid.length && j<grid[0].length) {
                int index = grid[i][j];
                if(mp.containsKey(index) && !set.contains(index)) {
                    tot += mp.get(index);
                    set.add(index);
                }
            }
        }
        return tot+1;
    }
    public void dfs(int x,int y,int[][] grid){
        if(x<0 || y<0 || x==grid.length || y==grid[0].length){
            return;
        }
        if(grid[x][y]!=1)
            return;
        arcnt++;
        grid[x][y]=index;
        for(int[] dir:dirs){
            int i=x+dir[0];
            int j=y+dir[1];
            dfs(i,j,grid);
        }
    }
}