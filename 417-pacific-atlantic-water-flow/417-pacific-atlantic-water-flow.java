class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        Queue<int[]> pc=new ArrayDeque<>();
        Queue<int[]> at=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            pc.add(new int[]{0,i});
            at.add(new int[]{n-1,i});
        }
        for(int i=0;i<n;i++){
            pc.add(new int[]{i,0});
            at.add(new int[]{i,m-1});
        }
        boolean pr[][]=bfs(pc,n,m,heights);
        boolean ar[][]=bfs(at,n,m,heights);
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(pr[i][j]==true && ar[i][j]==true)
                    ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }
    public boolean[][] bfs(Queue<int[]> q,int n,int m,int[][] heights){
        boolean res[][]=new boolean[n][m];
        int[][] dirs = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};
        while(q.size()>0){
            int tmp[]=q.remove();
            int x=tmp[0];
            int y=tmp[1];
            res[x][y]=true;
            
            for(int dir[]:dirs){
                int nx=x+dir[0];
                int ny=y+dir[1];
                if(nx<0 || ny<0 ||nx>=n ||ny>=m||res[nx][ny])
                    continue;
                if(heights[nx][ny]>=heights[x][y]){
                    
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return res;
    }
}