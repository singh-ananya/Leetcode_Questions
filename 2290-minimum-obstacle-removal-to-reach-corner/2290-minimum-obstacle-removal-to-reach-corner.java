class Solution {
        // Time complexity: O(mn)
        // Space complexity: O(mn)
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dist=new int[m][n];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        q.add(new int[]{0,0,grid[0][0]});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int t[]:dist){
            Arrays.fill(t,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        while(q.size()>0){
            int curr[]=q.remove();
            int x=curr[0];
            int y=curr[1];
            int d=curr[2];
            if(x==m-1 && y==n-1)
                return d;
            for(int dir[]:dirs){
                int row=x+dir[0];
                int col=y+dir[1];
                if(row>=0 && col>=0 && row<m && col<n){
                    if(d+grid[row][col]<dist[row][col]){
                        dist[row][col]=d+grid[row][col];
                        q.add(new int[]{row,col,dist[row][col]});
                    }
                }
            }
        }
        return -1;
    }
}