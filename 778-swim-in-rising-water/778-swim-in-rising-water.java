class Solution {
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int tsf;
        public Pair(int row,int col,int tsf){
            this.row=row;
            this.col=col;
            this.tsf=tsf;
        }
        public int compareTo(Pair o){
            return this.tsf-o.tsf;
        }
    }
    public int swimInWater(int[][] grid) {
       PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int n=grid.length;
        boolean vis[][]=new boolean[n][n];
        pq.add(new Pair(0,0,grid[0][0]));
        while(pq.size()>0){
            Pair rem=pq.remove();
            if(rem.row==n-1 && rem.col==n-1){
                return rem.tsf;
            }
            if(vis[rem.row][rem.col]==true){
                continue;
            }
            vis[rem.row][rem.col]=true;
            for(int i=0;i<4;i++){
                int r=rem.row+dirs[i][0];
                int c=rem.col+dirs[i][1];
                if(r<0 || c<0 || r>=n ||c>=n ||vis[r][c]==true){
                    continue;
                }
                pq.add(new Pair(r,c,Math.max(rem.tsf,grid[r][c])));
            }
        }
        return 0;
    }
}