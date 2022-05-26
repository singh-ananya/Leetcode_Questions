class Solution {
    class pair{
        int v;
        int level;
        pair(int v, int level){
            this.v=v;
            this.level=level;
        }
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> graph,int []vis,int src){
        Queue<pair> q=new ArrayDeque<>();
        q.add(new pair(src,0));
        while(q.size()>0){
            pair curr=q.remove();
            int level=curr.level;
            int v=curr.v;
            if(vis[v]!=-1){
                if(vis[v]!=level)
                    return false;
            }else{
                vis[v]=level;
            }
            for(int nbr:graph.get(v)){
                if(vis[nbr]==-1){
                    q.add(new pair(nbr,level+1));
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        
            for(int []g:dislikes){
                graph.get(g[0]).add(g[1]);
                graph.get(g[1]).add(g[0]);
            }
        
        int []vis=new int[n+1];
        Arrays.fill(vis,-1);
        for(int i=1;i<=n;i++){
            if(vis[i]==-1){
                boolean ans=bfs(graph,vis,i);
                if(ans==false)
                    return false;
            }
        }
        return true;
    }
}