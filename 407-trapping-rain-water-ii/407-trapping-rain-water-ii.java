class Solution {
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        Pair(int row,int col,int height){
            this.row=row;
            this.col=col;
            this.height=height;
        }
        public int compareTo(Pair o){
            return this.height-o.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    pq.add(new Pair(i,j,heightMap[i][j]));
                    vis[i][j]=true;
                }
            }
        }
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int water=0;
        while(pq.size()>0){
            Pair rem=pq.remove();
            for(int[] dir:dirs){
                int r=rem.row+dir[0];
                int c=rem.col+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && vis[r][c]==false){
                    water+=Math.max(0,rem.height-heightMap[r][c]);
                    
                    if(heightMap[r][c]>=rem.height){//if height of inner element is greater
                       pq.add(new Pair(r,c,heightMap[r][c])); 
                    }else{//if less height the delegate the prev height
                       pq.add(new Pair(r,c,rem.height)); 
                    }
                    vis[r][c]=true;
                    
                }
            }
        }
        return water;
    }
}