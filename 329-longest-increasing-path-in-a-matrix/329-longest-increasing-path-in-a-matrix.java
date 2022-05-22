class Solution {
    int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ind[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int nbr[]:dirs){
                    int x=nbr[0]+i;
                    int y=nbr[1]+j;
                    if(x>=0 && y>=0 && x<n && y<m && matrix[x][y]>matrix[i][j]){
                        ind[x][y]++;
                    }
                }
            }
        }
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ind[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        int level=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int curr[]=q.remove();
                int x=curr[0];
                int y=curr[1];
                for(int dir[]:dirs){
                    int i=x+dir[0];
                    int j=y+dir[1];
                    if(i>=0 && j>=0 && i<n && j<m && matrix[i][j]>matrix[x][y]){
                        ind[i][j]--;
                        if(ind[i][j]==0)
                            q.add(new int[]{i,j});
                    } 
                }
            }
            level++;
        }
        return level;
    }
}