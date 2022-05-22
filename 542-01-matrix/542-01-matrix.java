class Solution {
    //we will use BFS coz it ensures minimum distance
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j}); // we will put all the zeros into the queue because if we put 1's then we can loose the starting poins
                }
            }
        }
        int [][]ans=new int[mat.length][mat[0].length];
        for(int e[]:ans){
            Arrays.fill(e,-1); // -1 for unvisisted
        }
        int level=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int temp[]=q.remove();
                int x=temp[0];
                int y=temp[1];
                if(ans[x][y]!=-1)
                    continue;
                ans[x][y]=level;
                for(int dir[]:dirs)
                {
                    int i=x+dir[0];
                    int j=y+dir[1];
                    if(i>=0 && j>=0 && i<mat.length && j<mat[0].length && mat[i][j]!=-1)
                        q.add(new int[]{i,j});
                }
            }
            level++;
        }
        return ans;
    }
}