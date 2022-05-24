class Solution {
    //The first occurrence of 1 is the starting point of a land. We store this in the array in 0 and 1 position. Then we run a DFS. When we visit a cell we mark it with a 0. Now we check for the max index at the list and at current index being processed for both x and y and store it in the list at spot 3 and 4.
    int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] findFarmland(int[][] land) {
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1){
                    int ans[]=new int[]{i,j,0,0};
                    dfs(land,i,j,ans);
                    res.add(ans);
                }
            }
        }
        return res.toArray(new int[0][]);
        
    }
    public void dfs(int[][] land,int i,int j, int[] ans){
        land[i][j]=0;
        ans[2]=Math.max(ans[2],i);
        ans[3]=Math.max(ans[3],j);
        for(int[] dir:dirs){
            int x=dir[0]+i;
            int y=dir[1]+j;
            if(x>=0 && y>=0 && x<land.length && y<land[0].length && land[x][y]!=0){
                
                dfs(land,x,y,ans);
            }
        }
    }
}