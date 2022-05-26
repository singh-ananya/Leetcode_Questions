class Solution {
    // class pair{
    //     int v;
    //     int level;
    //     pair(int v, int level){
    //         this.v=v;
    //         this.level=level;
    //     }
    // }
    public boolean bfs(ArrayList<ArrayList<Integer>> graph,int []vis,int src){
        Queue<Integer> q=new ArrayDeque<>();
        int color=0;
        q.add(src);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int tmp=q.remove();
                if(vis[tmp]!=-1){
                    if(vis[tmp]!=color)
                        return false;
                }
                vis[tmp]=color;
                for(int nbr:graph.get(tmp)){
                    if(vis[nbr]==-1){
                        q.add(nbr);
                        
                    }
                }
            }
            color=(color+1)%2;
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