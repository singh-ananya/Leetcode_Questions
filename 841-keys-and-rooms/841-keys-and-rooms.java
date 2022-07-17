class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        Arrays.fill(vis,false);
        dfs(rooms,0,vis);
        boolean ans=true;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                ans=false;
                break;
            }
        }
        return ans;
        
    }
    public void dfs(List<List<Integer>> graph,int src,boolean vis[]){
        vis[src]=true;
        for(int nbr:graph.get(src)){
            if(!vis[nbr]){
                dfs(graph,nbr,vis);
            }
        }
    }
}