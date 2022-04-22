class Solution {
    public int maxDistance(int[][] grid) {
        
        int [][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
        LinkedList<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    q.addLast(new int[]{i,j});
            }
        }
        if (q.isEmpty()){
            return -1;
        }
        if (q.size()==grid.length*grid[0].length){
            return -1;
        }
        int level = 0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int[] curr=q.removeFirst();
                for(int dir[]:dirs){
                   int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==0)
                    {
                        q.addLast(new int[]{x,y});
                        grid[x][y]=1;
                    }
                }
            }
            level++;
        }
        return level-1;
        
    }
}