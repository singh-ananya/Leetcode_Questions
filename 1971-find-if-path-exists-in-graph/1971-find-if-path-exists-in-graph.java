class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        if(src==des)
            return true;
        ArrayList<Integer>[] graph=new ArrayList[n];
    for(int i =0 ;i<n;i++){
    graph[i] = new ArrayList<>();
     }

    for(int [] edge : edges){
        graph[edge[0]].add(edge[1]);
        graph[edge[1]].add(edge[0]);
    }
        return dfs(src,des,graph,new boolean[n]);
        
    }
    public boolean dfs(int src,int dst,ArrayList<Integer> graph[],boolean[] vis){
        if(src==dst)
            return true;
        vis[src]=true;
        for(int nbr:graph[src]){
            if(vis[nbr]==false){
                boolean hasPath=dfs(nbr,dst,graph,vis);
                if(hasPath==true)
                    return true;
            }
        }
        return false;
    }
}